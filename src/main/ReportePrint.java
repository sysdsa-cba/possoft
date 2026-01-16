/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import util.AdaptadorJDBC;
import util.ExportExcel;
import util.Fecha;
import util.RegistroActual;

/**
 *
 * @author xvr
 */
class ReportePrint implements Printable {

    static Fecha fecha;

    double totalGeneral = 0;
    double ventasNetas = 0;
    double montoNeto = 0.0;

    static {
        try {

            AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");

            datos.consultar("select fecha as fecha from fecha_reporte");

            while (datos.resultados.next()) {
                fecha = new Fecha().setFechaMySQL(datos.resultados.getString(1));
                System.out.println(datos.resultados.getString(1));
            }

            datos.cerrar();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    SimpleDateFormat df = new SimpleDateFormat();
    String receiptDetailLine;

    public static final String pspace = "               ";//15-spaces

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
            throws PrinterException {

        try {

            AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");

            datos.consultar("select fecha as fecha from fecha_reporte");

            while (datos.resultados.next()) {
                fecha = new Fecha().setFechaMySQL(datos.resultados.getString(1));
                System.out.println(datos.resultados.getString(1));
            }

            datos.cerrar();

        } catch (Exception e) {
            System.err.println(e);
        }

        // System.out.println();
        df.applyPattern("dd/MM/yyyy HH:mm:ss");
        String strText = null;
        final String LF = "\n";// text string to output
        int lineStart;           // start index of line in textarea
        int lineEnd;             // end index of line in textarea
        int lineNumber;
        int lineCount;
        final String SPACE = "          ";//10 spaces
        final String SPACES = "         ";//9
        final String uline = "________________________________";
        final String dline = "----------------------------------";
        // String greetings = "THANKS FOR YOUR VISIT";
        String greetings = "";

        //String fecha = df.format(new Date());
        String encabezado = "\n\nFecha: " + fecha.getFecha();// + "    Hora: " + fecha.substring(11, fecha.length() - 3) + "\n";
        String encabezado2 = "\nProducto     Cantidad     Importe\n";

        Graphics2D g2d = (Graphics2D) graphics;
        Font font = new Font("Consolas", Font.BOLD, 7);

        if (pageIndex < 0 || pageIndex >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        JTextArea textarea = new JTextArea(10, 80);

        ArrayList<NCP> itemsReporte = new ArrayList();
        ArrayList<NCP> itemsReporteDevolucion = new ArrayList();

        String consulta_ventas = """
                                 select registro, left(hora,5), 
                                 (select count(*) from itemventas i where i.REGISTRO = v.REGISTRO) as items ,v.TOTAL as total, 
                                 case when v.CODSUC = 0 then "Venta"
                                 when v.CODSUC = -1 then "Dev" end as opp
                                 from ventas v
                                 where fecha = '""" + fecha.getFechaMySQL() + "'\n"
                + "order by hora";

        try {

            AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");

            String consulta = "select v.fecha,iv.NOMBRE , sum(iv.CANT) , sum(iv.PRECIO*iv.CANT )\n"
                    + "from ventas v\n"
                    + "join itemventas iv on iv.REGISTRO = v.REGISTRO \n"
                    + "where fecha = '" + fecha.getFechaMySQL() + "' \n"
                    + "and v.codsuc = 0 "
                    + "group by  fecha, nombre";

            System.err.println("consulta ventas: \n" + consulta);
            datos.consultar(consulta);
//            System.err.println(consulta);

            while (datos.resultados.next()) {
                itemsReporte.add(new NCP(datos.resultados.getString(2),
                        datos.resultados.getInt(3), datos.resultados.getDouble(4)));

            }
            datos.cerrar();
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");

            String consulta_devoluciones = "select v.fecha,iv.NOMBRE , sum(iv.CANT) , sum(iv.PRECIO*iv.CANT )\n"
                    + "from ventas v\n"
                    + "join itemventas iv on iv.REGISTRO = v.REGISTRO \n"
                    + "where fecha = '" + fecha.getFechaMySQL() + "' \n"
                    + "and v.codsuc = -1 "
                    + "group by  fecha, nombre";

            datos.consultar(consulta_devoluciones);
            System.err.println("Consulta devoluciones: " + consulta_devoluciones);

            while (datos.resultados.next()) {
                itemsReporteDevolucion.add(new NCP(datos.resultados.getString(2),
                        datos.resultados.getInt(3), datos.resultados.getDouble(4)));

            }
        } catch (Exception e) {
        }

        System.out.println(itemsReporteDevolucion);

        textarea.append("\n" + encabezado + "\nVENTAS\n");
        textarea.append(encabezado2);
        textarea.append(dline + "\n");

        double montoVentas = 0;
        double cantVentas = 0;

        for (NCP it : itemsReporte) {
            String prod = String.format("%" + (-15) + "s", it.nombre);
            String cant = String.format("%" + (5) + "s", it.cantidad);
            String precio = String.format("%" + (12) + "s", formato(it.precio).substring(2));
            //String subtotal = String.format("%" + (7) + "s", it.cant * it.precio).substring(0, 7);

            textarea.append(prod + " " + cant + " " + precio + " " + LF);

            montoVentas += it.precio;
            cantVentas += it.cantidad;
        }

        textarea.append(dline + "\n");
        textarea.append(String.format("%-15s", "TOTALES") + " " + String.format("%" + 5 + "s", cantVentas) + "  " + String.format("%10s", formato(montoVentas)) + LF);
        // String printedLine = "       Service Charge Complimentary";
        //textarea.append(printedLine + LF);
//08005555278 op
//        textarea.append("          " + greetings + LF);

        textarea.append("\n\nDEVOLUCIONES\n");
        textarea.append(encabezado2);
        textarea.append(dline + "\n");

        double montoDevoluciones = 0;
        double cantDevoluciones = 0;

        for (NCP it : itemsReporteDevolucion) {
            String prod = String.format("%" + (-15) + "s", it.nombre);
            String cant = String.format("%" + (5) + "s", it.cantidad);
            String precio = String.format("%" + (12) + "s", formato(it.precio).substring(2));
            //String subtotal = String.format("%" + (7) + "s", it.cant * it.precio).substring(0, 7);
            textarea.append(prod + " " + cant + " " + precio + " " + LF);

            montoDevoluciones -= it.precio;
            cantDevoluciones += it.cantidad;
        }

        /*total = 0;
        for (NCP it_dev : itemsReporteDevolucion) {
            total -= it_dev.precio;
        }*/
//        System.out.println(itemsReporteDevolucion);
        textarea.append(dline + "\n");
        textarea.append(String.format("%-15s", "TOTALES") + " " + String.format("%" + 5 + "s", cantDevoluciones) + "  " + String.format("%10s", formato(montoDevoluciones)) + LF + "\n");

        totalGeneral = cantDevoluciones + cantVentas;
        montoNeto = montoDevoluciones + montoVentas;

        textarea.append(String.format("%-15s", "TOTAL NETO") + " " + String.format("%" + 5 + "s", totalGeneral) + "  " + String.format("%10s", formato(montoNeto)) + LF);

        
        /*  try {
            AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");
            
            datos.consultar(consulta_ventas);
            
            while(datos.resultados.next()){
                
                for (int i = 0; i < 5; i++) {
                    textarea.append(datos.resultados.getString(i+1) + " ");                  
                    
                }
                textarea.append("\n");
            }
        } catch (Exception e) {
        }*/

        textarea.setEditable(false);

        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        g2d.setFont(font);
        lineNumber = 0;
        lineCount = textarea.getLineCount();
        strText = textarea.getText();
        System.err.println(textarea.getText());
        /*MediaTracker mt = new MediaTracker(textarea);
         URL imageURL = null;
         try {

         imageURL = new URL(mainDirectory+"quindell.png");
         } catch (MalformedURLException me) {
         me.printStackTrace();
         }

         //--- Load the image and wait for it to load
         Image image = Toolkit.getDefaultToolkit().getImage(imageURL);
         mt.addImage(image, 0);
         */
        // g2d.drawImage(new javax.swing.ImageIcon("logo5.jpg").getImage(), 0, 0, null);
        while (lineCount != 0) {
            try {

                lineStart = textarea.getLineStartOffset(lineNumber);
                lineEnd = textarea.getLineEndOffset(lineNumber);
                strText = textarea.getText(lineStart, lineEnd - lineStart);
            } catch (Exception exception) {
                System.out.println("Printing error:" + exception);                  // have to catch BadLocationException
            }

            //   g2d.dr
            g2d.drawString(strText, 1, (lineNumber + 1) * 10);
            //spacing    between lines
            lineNumber = lineNumber + 1;
            lineCount--;
        }
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) {
        //new Print().b();

        new Print().reporte();
    }

    public static String formato(double mnt) {
        //Get current locale information
        Locale currentLocale = new Locale("es", "AR");

        /* for(Locale l: Locale.getAvailableLocales()){
            System.out.println(l);
        }*/
//Get currency instance from locale; This will have all currency related information
        Currency currentCurrency = Currency.getInstance(currentLocale);

//Currency Formatter specific to locale
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);

        return currencyFormatter.format(mnt);
    }
}

class NCP {

    String nombre;
    int cantidad;
    double precio;

    public NCP(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " " + cantidad + " " + precio; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
