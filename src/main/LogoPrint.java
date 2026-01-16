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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import util.RegistroActual;

/**
 *
 * @author xvr
 */
class LogoPrint implements Printable {

    SimpleDateFormat df = new SimpleDateFormat();
    String receiptDetailLine;

    public static final String pspace = "               ";//15-spaces

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
            throws PrinterException {

        Graphics2D g2d = (Graphics2D) graphics;
        
        System.out.println();
        df.applyPattern("dd/MM/yyyy HH:mm:ss");
        String strText = null;
        final String LF = "\n";// text string to output
        int lineStart;           // start index of line in textarea
        int lineEnd;             // end index of line in textarea
        int lineNumber;
        int lineCount;
              

        receiptDetailLine = "asdasdasda";

        
        Font font = new Font("Courier New", Font.BOLD, 7);

        if (pageIndex < 0 || pageIndex >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        JTextArea textarea = new JTextArea(10, 40);

       


        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        g2d.setFont(font);
        lineNumber = 0;
        lineCount = textarea.getLineCount();
        strText = textarea.getText();

        ImageIcon logo = new javax.swing.ImageIcon("logo5.jpg");
        JOptionPane.showMessageDialog(null, logo.getDescription());
        graphics.drawImage(logo.getImage(), 0, 0, null);

        while (lineCount != 0) {
            try {

                lineStart = textarea.getLineStartOffset(lineNumber);
                lineEnd = textarea.getLineEndOffset(lineNumber);
                strText = textarea.getText(lineStart, lineEnd - lineStart);
            } catch (Exception exception) {
                System.out.println("Printing error:" + exception);                  // have to catch BadLocationException
            }

            //   g2d.dr
            

         //   g2d.drawString(strText, 1, (lineNumber + 1) * 18);
            //spacing    between lines
            lineNumber = lineNumber + 1;
            lineCount--;
        }
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) {
        new Print().b();
    }

    
}
