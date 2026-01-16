/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import static main.ReportePrint.fecha;
import util.ExportExcel;

public class Print {

    static ArrayList<Integer> cant = new ArrayList();

    public void a() {
        PageFormat format = new PageFormat();
        Paper paper = new Paper();

        double paperWidth = 2.439;//3;//3.25
        double paperHeight = 3;//3.69;//11.69
        double leftMargin = 0.5;
        double rightMargin = 0.5;
        double topMargin = 0;
        double bottomMargin = 0.01;

        paper.setSize(paperWidth * 200, paperHeight * 200);
        paper.setImageableArea(leftMargin * 200, topMargin * 200,
                (paperWidth - leftMargin - rightMargin) * 200,
                (paperHeight - topMargin - bottomMargin) * 200);

        format.setPaper(paper);

        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(OrientationRequested.PORTRAIT);
//testing 

        PrinterJob printerJob = PrinterJob.getPrinterJob();
        Printable printable = new ReceiptPrint();

        format = printerJob.validatePage(format);
       // boolean don = printerJob.printDialog();
        printerJob.setPrintable(printable, format);
        try {
            printerJob.print(aset);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        PageFormat format = new PageFormat();
        Paper paper = new Paper();

        double paperWidth = 2.439;//3;//3.25
        double paperHeight = 3;//3.69;//11.69
        double leftMargin = 0.12;
        double rightMargin = 0.10;
        double topMargin = 0;
        double bottomMargin = 0.1;

        paper.setSize(paperWidth * 200, paperHeight * 200);
        paper.setImageableArea(leftMargin * 200, topMargin * 200,
                (paperWidth - leftMargin - rightMargin) * 200,
                (paperHeight - topMargin - bottomMargin) * 200);

        format.setPaper(paper);

        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(OrientationRequested.PORTRAIT);
//testing 

        PrinterJob printerJob = PrinterJob.getPrinterJob();
        Printable printable = new LogoPrint();
        PrintService foundService = PrintServiceLookup.lookupDefaultPrintService();

        format = printerJob.validatePage(format);

        try {
            printerJob.setPrintService(foundService);
            printerJob.setPrintable(printable, format);
            printerJob.print(aset);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
      public void dev() {
        PageFormat format = new PageFormat();
        Paper paper = new Paper();

        double paperWidth = 2.439;//3;//3.25
        double paperHeight = 3;//3.69;//11.69
        double leftMargin = 0.12;
        double rightMargin = 0.10;
        double topMargin = 0;
        double bottomMargin = 0.01;

        paper.setSize(paperWidth * 200, paperHeight * 200);
        paper.setImageableArea(leftMargin * 200, topMargin * 200,
                (paperWidth - leftMargin - rightMargin) * 200,
                (paperHeight - topMargin - bottomMargin) * 200);

        format.setPaper(paper);

        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(OrientationRequested.PORTRAIT);
//testing 

        PrinterJob printerJob = PrinterJob.getPrinterJob();
        Printable printable = new DevolucionPrint();

        format = printerJob.validatePage(format);
       // boolean don = printerJob.printDialog();
        printerJob.setPrintable(printable, format);
        try {
            printerJob.print(aset);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void reporte() {
        PageFormat format = new PageFormat();
        Paper paper = new Paper();

        double paperWidth = 2.439;//3;//3.25
        double paperHeight = 3;//3.69;//11.69
        double leftMargin = 0.12;
        double rightMargin = 0.10;
        double topMargin = 0;
        double bottomMargin = 0.1;

        paper.setSize(paperWidth * 200, paperHeight * 200);
        paper.setImageableArea(leftMargin * 200, topMargin * 200,
                (paperWidth - leftMargin - rightMargin) * 200,
                (paperHeight - topMargin - bottomMargin) * 200);

        format.setPaper(paper);

        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(OrientationRequested.PORTRAIT);
//testing 

        PrinterJob printerJob = PrinterJob.getPrinterJob();
        Printable printable = new ReportePrint();
        /*PrintService foundService = PrintServiceLookup.lookupDefaultPrintService();

        format = printerJob.validatePage(format);

        try {
            printerJob.setPrintService(foundService);
            printerJob.setPrintable(printable, format);
            printerJob.print(aset);
        } catch (Exception e) {
            e.printStackTrace();
        }
         */
        boolean don = printerJob.printDialog();
        printerJob.setPrintable(printable, format);
        try {
            printerJob.print(aset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            ExportExcel.exportarExcel(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }
}
