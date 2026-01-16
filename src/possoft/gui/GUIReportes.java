/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package possoft.gui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import main.Print;
import util.AdaptadorJDBC;
import util.Fecha;
import util.Util;

/**
 *
 * @author xvr
 */
public class GUIReportes extends javax.swing.JFrame {

    /**
     * Creates new form GUIReportes
     */
    public GUIReportes() {
        initComponents();

        ArrayList<Object[]> registros = new ArrayList();

        try {

            String consulta = "select v.fecha, sum(iv.cant) as cantidad, sum(iv.precio) as importe\n"
                    + "from ventas v\n"
                    + "join itemventas iv on iv.REGISTRO = v.REGISTRO "
                    + "where v.codsuc = 0\n"
                    + "group by fecha\n"
                    + "order by fecha desc";
            
            consulta = """
                       select v.fecha as fecha, (select sum(i.CANT) from itemventas i where i.fechaentrega = v.fecha and i.CODSUC = 0) as ventas,
                       (select sum(i.CANT) from itemventas i where i.fechaentrega = v.fecha and i.CODSUC = -1) as devoluciones,
                       (select sum(i.PRECIO*i.cant) from itemventas i where i.fechaentrega = v.fecha and CODSUC = 0) as importe_ventas,
                       (select sum(i.PRECIO*(-i.cant)) from itemventas i where i.fechaentrega = v.fecha and CODSUC = -1) as importe_devoluciones,
                       (select sum(i.PRECIO*i.cant) from itemventas i where i.fechaentrega = v.fecha) as importe_neto
                       from ventas v
                       group by v.fecha
                       order by v.fecha desc
                       """;

            AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");
            
            //System.err.println("consulta devolucion: " + consulta);

            double inicio = 0;
            double fin = 0;
            
            inicio = System.currentTimeMillis();
            datos.consultar(consulta);
            fin = System.currentTimeMillis();
            
            System.out.println(fin -  inicio);

            while (datos.resultados.next()) {
                Fecha fecha = new Fecha().setFechaMySQL(datos.resultados.getString(1));
                int ventas = datos.resultados.getInt(2);
                int devoluciones = datos.resultados.getInt(3);
                double ventas_monto = datos.resultados.getDouble(4);
                double devoluciones_monto =  datos.resultados.getDouble(5);

                registros.add(new Object[]{
                    fecha.getFecha(),
                    Util.formato(ventas),
                     Util.formato(devoluciones),
                    Util.formato(ventas_monto),
                    Util.formato(devoluciones_monto),
                    Util.formato(ventas + devoluciones),
                    Util.formato(ventas_monto+ devoluciones_monto)
                });

            }

        } catch (Exception e) {
            System.err.println(e);
        }

        Object[][] data = new Object[registros.size()][];

        for (int i = 0; i < data.length; i++) {
            data[i] = registros.get(i);

        }

        tReportes.setModel(new javax.swing.table.DefaultTableModel(
                data,
                new String[]{
                    "Fecha", "Ventas", "Devoluciones", "Imp. Ventas", "Imp. Devoluciones", "Ventas Netas", "Imp. Neto"
                }
        ));
        jScrollPane1.setViewportView(tReportes);

        tReportes.setRowSelectionInterval(0, 0);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        tReportes.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tReportes.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tReportes.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);

       // tReportes.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tReportes.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        tReportes.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        tReportes.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        //tStock.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());

        } catch (Exception e) {
        }

        FlatLightLaf.setup();
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(23, 180, 252));
        this.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tReportes = new javax.swing.JTable();
        bImprimir = new javax.swing.JButton();
        tFecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Impresión de Reportes Diarios");
        setPreferredSize(new java.awt.Dimension(700, 400));

        tReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tReportes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tReportesFocusGained(evt);
            }
        });
        tReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tReportesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tReportes);

        bImprimir.setText("Imprimir");
        bImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bImprimirActionPerformed(evt);
            }
        });

        tFecha.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tFecha))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(bImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bImprimirActionPerformed
        // TODO add your handling code here:

        int row = tReportes.getSelectedRow();
        int col = tReportes.getSelectedColumn();

//        String fecha = tReportes.getValueAt(row, 0).toString();
            String fecha = tFecha.getText();

        try {
            fecha = new Fecha().setFechaEstandar(fecha).getFechaMySQL();
        } catch (Exception e) {
        }

        try {
            String consulta = "update fecha_reporte set fecha = '" + fecha + "' ";

            AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");

            datos.actualizar(consulta);
            datos.cerrar();

        } catch (Exception e) {
            System.err.println("Erorrrr");
        }

        new Print().reporte();
    }//GEN-LAST:event_bImprimirActionPerformed

    private void tReportesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tReportesFocusGained
        // TODO add your handling code here:
        tFecha.setText(tReportes.getValueAt(tReportes.getSelectedRow(), 0)+"");
    }//GEN-LAST:event_tReportesFocusGained

    private void tReportesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tReportesMousePressed
        // TODO add your handling code here:
          tFecha.setText(tReportes.getValueAt(tReportes.getSelectedRow(), 0)+"");
    }//GEN-LAST:event_tReportesMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());

        } catch (Exception e) {
        }

        FlatLightLaf.setup();
        JFrame.setDefaultLookAndFeelDecorated(true);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bImprimir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tFecha;
    private javax.swing.JTable tReportes;
    // End of variables declaration//GEN-END:variables
}
