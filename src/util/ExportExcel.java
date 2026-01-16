/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author xvr
 */
public class ExportExcel {

    public static ArrayList<NCP> getItemsVentas(Fecha fecha) {

        ArrayList<NCP> itemsReporte = new ArrayList();

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
        return itemsReporte;
    }

    public static ArrayList<NCP> getItemsDevoluciones(Fecha fecha) {

        ArrayList<NCP> itemsReporte = new ArrayList();

        try {

            AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");

            String consulta = "select v.fecha,iv.NOMBRE , sum(iv.CANT) , sum(iv.PRECIO*iv.CANT )\n"
                    + "from ventas v\n"
                    + "join itemventas iv on iv.REGISTRO = v.REGISTRO \n"
                    + "where fecha = '" + fecha.getFechaMySQL() + "' \n"
                    + "and v.codsuc = -1 "
                    + "group by  fecha, nombre";

            System.err.println("consulta devoluciones: \n" + consulta);
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
        return itemsReporte;
    }

    public static void main(String[] args) throws Exception {
        Fecha fecha = new Fecha().setFechaMySQL("2023-06-07");

        exportarExcel(fecha);
    }

    public static void exportarExcel(Fecha fecha) throws Exception {
        // CONSTANTS

        int index = 0;

        int A_COL = 0;
        int B_COL = 1;
        int C_COL = 2;

        int A_WIDTH = 150;
        int B_WIDTH = 80;
        int C_WIDTH = 100;

        int FACTOR = 30;

        // CREATION OF WORKBOOK AND SHEETS
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("" + fecha.getFecha3('-'));

        // Set columns width
        sheet.setColumnWidth(A_COL, A_WIDTH * FACTOR);
        sheet.setColumnWidth(B_COL, B_WIDTH * FACTOR);
        sheet.setColumnWidth(C_COL, C_WIDTH * FACTOR);

        CellStyle currencyStyle = workbook.createCellStyle();
        CellStyle headerStyle = workbook.createCellStyle();
        CellStyle footerStyle = workbook.createCellStyle();
        DataFormat currencyFormat = workbook.createDataFormat();

        currencyStyle.setDataFormat(currencyFormat.getFormat("$ #,##0.00"));

        Font headerFont = workbook.createFont();

        headerFont.setBold(true);
//        headerFont.setFontName("Comic Sans MS");

        headerStyle.setFont(headerFont);
        footerStyle.setFont(headerFont);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        footerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        footerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        footerStyle.setDataFormat(currencyFormat.getFormat("$ #,##0.00"));

        /////// DATOS DE VENTAS
        ArrayList<NCP> itemsReporte = getItemsVentas(fecha);
        ArrayList<NCP> tableData = itemsReporte;

// Your list of objects representing the table data
        Row fechaRow = sheet.createRow(index);

        Cell fechaTitulo = fechaRow.createCell(0);
        fechaTitulo.setCellValue("Fecha");

        CellRangeAddress mergedFecha = new CellRangeAddress(index, index, 1, 2);
        sheet.addMergedRegion(mergedFecha);

        Cell fechaST = fechaRow.createCell(1);
        fechaST.setCellValue(fecha.getFecha());
        CellStyle fechaStyle = workbook.createCellStyle();
        fechaStyle.setAlignment(HorizontalAlignment.RIGHT);
        fechaST.setCellStyle(fechaStyle);

        index += 2;

        CellRangeAddress mergedtTituloVentas = new CellRangeAddress(index, index, 0, 2);
        sheet.addMergedRegion(mergedtTituloVentas);

        Row rTituloVentas = sheet.createRow(index);
        Cell tituloVentas = rTituloVentas.createCell(0);
        tituloVentas.setCellValue("VENTAS");
        index++;

// Create header row
        Row headerRow = sheet.createRow(index);
        index++;
        String[] titulos = {"Nombre", "Cantidad", "Precio"};

        int idx = 0;

        for (String titulo : titulos) {
            Cell headerCell = headerRow.createCell(idx++);
            headerCell.setCellValue(titulo.toUpperCase());
            headerCell.setCellStyle(headerStyle);
        }

        tituloVentas.setCellStyle(headerStyle);

// Add more header cells as needed
        int subtotalCantidadVentas = 0;
        double subtotalPrecioVentas = 0;

        CellStyle centro = workbook.createCellStyle();
        centro.setAlignment(HorizontalAlignment.CENTER);

// Populate table data
        for (int i = 0; i < tableData.size(); i++) {
            NCP rowData = tableData.get(i);
            Row dataRow = sheet.createRow(index);
            index++;

            String nombre = rowData.getNombre();
            int cantidad = rowData.getCantidad();
            double precio = rowData.getPrecio();

            subtotalCantidadVentas += cantidad;
            subtotalPrecioVentas += precio;

            dataRow.createCell(0).setCellValue(nombre);

            Cell celdaCantidad = dataRow.createCell(1);
            celdaCantidad.setCellValue(cantidad);
            celdaCantidad.setCellStyle(centro);

            Cell celdaPrecio = dataRow.createCell(2);
            celdaPrecio.setCellValue(precio);
            celdaPrecio.setCellStyle(currencyStyle);

            // dataRow.createCell(2).setCellValue(rowData.getPrecio());
            // Add more cells and properties as needed
        }

        Row subtotalesVentasRow = sheet.createRow(index);
        Cell subtotalVentasLabel = subtotalesVentasRow.createCell(0);
        subtotalVentasLabel.setCellValue("TOTALES");
        subtotalVentasLabel.setCellStyle(headerStyle);

        Cell subtotalcantidad = subtotalesVentasRow.createCell(1);
        subtotalcantidad.setCellValue(subtotalCantidadVentas);
        subtotalcantidad.setCellStyle(headerStyle);

        Cell subtotalesventas = subtotalesVentasRow.createCell(2);
        subtotalesventas.setCellStyle(footerStyle);
        subtotalesventas.setCellValue(subtotalPrecioVentas);

//        subtotalesVentasRow.createCell(2).setCellValue(subtotalPrecioVentas);
        /////////////////////////// DEVOLUCIONES
        index += 2;

        CellRangeAddress mergedtTituloDevoluciones = new CellRangeAddress(index, index, 0, 2);
        sheet.addMergedRegion(mergedtTituloDevoluciones);

        Row rTituloDevs = sheet.createRow(index);
        Cell tituloDevs = rTituloDevs.createCell(0);
        tituloDevs.setCellValue("DEVOLUCIONES");
        tituloDevs.setCellStyle(headerStyle);
        index++;

// Create header row
        headerRow = sheet.createRow(index);
        index++;

        idx = 0;

        for (String titulo : titulos) {
            Cell headerCell = headerRow.createCell(idx++);
            headerCell.setCellValue(titulo.toUpperCase());
            headerCell.setCellStyle(headerStyle);
        }

// Add more header cells as needed
        int subtotalCantidadDevs = 0;
        double subtotalPrecioDevs = 0;

        ArrayList<NCP> tableDataDevoluciones = getItemsDevoluciones(fecha);

// Populate table data
        for (int i = 0; i < tableDataDevoluciones.size(); i++) {
            NCP rowData = tableDataDevoluciones.get(i);
            Row dataRow = sheet.createRow(index);
            index++;

            String nombre = rowData.getNombre();
            int cantidad = rowData.getCantidad();
            double precio = rowData.getPrecio();
            subtotalCantidadDevs += cantidad;
            subtotalPrecioDevs -= precio;

            Cell nombreProducto = dataRow.createCell(A_COL);
            nombreProducto.setCellValue(nombre);
            Cell celdaCantidad = dataRow.createCell(B_COL);
            celdaCantidad.setCellValue(cantidad);
            celdaCantidad.setCellStyle(centro);

            Cell precioCell = dataRow.createCell(C_COL);
            precioCell.setCellValue(precio);
            precioCell.setCellStyle(currencyStyle);

            // dataRow.createCell(2).setCellValue(rowData.getPrecio());
            // Add more cells and properties as needed
        }

        Row subtotalesDevsRow = sheet.createRow(index);
        Cell subDevsLab = subtotalesDevsRow.createCell(A_COL);
        Cell subDevsCant = subtotalesDevsRow.createCell(B_COL);
        Cell subDevsTot = subtotalesDevsRow.createCell(C_COL);

        subDevsLab.setCellValue("TOTALES");
        subDevsLab.setCellStyle(headerStyle);
        subDevsCant.setCellValue(subtotalCantidadDevs);
        subDevsCant.setCellStyle(headerStyle);
        subDevsTot.setCellValue(subtotalPrecioDevs);
        subDevsTot.setCellStyle(footerStyle);
        
        String pathSoft = System.getenv("path_soft");

        File archivoSalida = new File(pathSoft + "/exp/xls/" + fecha.getFecha3('-') + ".xlsx");

        int ventasNetas = subtotalCantidadVentas + subtotalCantidadDevs;
        double ventasMontoNeto = subtotalPrecioVentas + subtotalPrecioDevs;

        index += 2;

        Row lineaFinal = sheet.createRow(index);
        Cell generalLabel = lineaFinal.createCell(A_COL);
        generalLabel.setCellValue("Total General".toUpperCase());
        generalLabel.setCellStyle(headerStyle);
        
        Cell generalVentas = lineaFinal.createCell(B_COL);
        generalVentas.setCellValue(ventasNetas);
        generalVentas.setCellStyle(headerStyle);
        
        Cell generalNeto = lineaFinal.createCell(C_COL);
        generalNeto.setCellValue(ventasMontoNeto);
        generalNeto.setCellStyle(footerStyle);

        FileOutputStream outputStream = new FileOutputStream(archivoSalida);
//        JOptionPane.showMessageDialog(null, archivoSalida.getAbsolutePath());
        workbook.write(outputStream);

    }
}

class Persona {

    int id = 0;
    String nombre = "";
    String direccion = "";

    public Persona() {
        id = 1;
        nombre = "Bengolea, Javier";
        direccion = "Cavalotti 365";
    }

    public Persona(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
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

    public NCP() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + " " + cantidad + " " + precio; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
