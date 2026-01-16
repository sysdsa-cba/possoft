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
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import javax.swing.JTextArea;
import util.RegistroActual;

/**
 *
 * @author xvr
 */
class DevolucionPrint implements Printable {

    SimpleDateFormat df = new SimpleDateFormat();
    String receiptDetailLine;

    public static final String pspace = "               ";//15-spaces

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
            throws PrinterException {

        System.out.println();
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
        final String dline = "--------------------------------";
        // String greetings = "THANKS FOR YOUR VISIT";
        String greetings = "\n\nMUCHAS GRACIAS!!!";

        String fecha = df.format(new Date());
        String encabezado = "\n\nDEVOLUCION\nFecha: " + fecha.substring(0, 10) + " Hora: " + fecha.substring(11, fecha.length() - 3) + "\n";
        String encabezado2 = "Can " + "Producto     " + "Precio  " + "Importe" + "\n";

        receiptDetailLine = "asdasdasda";

        Graphics2D g2d = (Graphics2D) graphics;
        Font font = new Font("Consolas", Font.BOLD, 7);

        if (pageIndex < 0 || pageIndex >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        JTextArea textarea = new JTextArea(10, 80);

        ItemVentas[] items = new ItemVentas[0];
        Ventas venta = new Ventas();
        int registro = RegistroActual.getRegistroActual();

        try {
            items = ItemVentas.leerItemVentasPorRegistro(registro + "",
                    "root", "admin");
            venta = Ventas.leerVentasPorRegistro(registro + "", "root", "admin")[0];

        } catch (Exception e) {
            System.err.println(e);
        }

        textarea.append("\n\n\n\n" + encabezado);
        textarea.append(encabezado2);
        textarea.append(dline + "\n");

        for (ItemVentas it : items) {
            String cant = String.format("%" + (3) + "s", (int) it.cant);
            String producto = String.format("%" + (-12) + "s", it.nombre).substring(0, 12);
            String precioIndividual = String.format("%" + (7) + "s", it.precio).substring(0, 7);
            String subtotal = String.format("%" + (7) + "s", it.cant * it.precio).substring(0, 7);

            textarea.append(cant + " " + producto + " " + precioIndividual + " " + subtotal + LF);
        }

        textarea.append(dline + "\n");
        textarea.append(String.format("%-20s", "TOTAL") + " " + String.format("%10s", formato(venta.getTotal())) + LF);
        // String printedLine = "       Service Charge Complimentary";
        //textarea.append(printedLine + LF);
//08005555278 op
        textarea.append("          " + greetings + LF);

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
        g2d.drawImage(new javax.swing.ImageIcon("logo5.jpg").getImage(), 0, 0, null);
        while (lineCount != 0) {
            try {

                lineStart = textarea.getLineStartOffset(lineNumber);
                lineEnd = textarea.getLineEndOffset(lineNumber);
                strText = textarea.getText(lineStart, lineEnd - lineStart);
            } catch (Exception exception) {
                System.out.println("Printing error:" + exception);                  // have to catch BadLocationException
            }

            //   g2d.dr
            g2d.drawString(strText, 1, (lineNumber + 1) * 20);
            //spacing    between lines
            lineNumber = lineNumber + 1;
            lineCount--;
        }
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) {
        //new Print().b();
        new Print().a();
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
