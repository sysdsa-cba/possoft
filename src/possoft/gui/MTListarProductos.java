/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package possoft.gui;

import java.util.Vector;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xvr
 */
public class MTListarProductos extends DefaultTableModel {

    String[] titulos;
    Object[][] datos;

    public MTListarProductos(Object[][] datos, String[] titulos) {
        super();
        this.datos = datos;
        this.titulos = titulos;

        Vector<Vector> data = new Vector();
        Vector temp;

        for (int i = 0; i < datos.length; i++) {
            temp = new Vector();
            for (int j = 0; j < datos[0].length; j++) {
                temp.add(datos[i][j]);

            }
            data.add(temp);
        }

        this.dataVector = data;
        this.columnIdentifiers = convertToVector(titulos);
    }

    final static Class[] COLUMN_CLASS = new Class[]{
        String.class, String.class, String.class, String.class,
        String.class, String.class, Double.class
    };

    public static Integer[] ANCHOS = new Integer[]{
        80, 120, 80, 80, 60, 60, 60
    };

    public static final Integer[] ALINEACIONES = new Integer[]{
        SwingUtilities.LEADING, SwingUtilities.LEADING,
        SwingUtilities.LEADING, SwingUtilities.LEADING,
        SwingUtilities.RIGHT, SwingUtilities.RIGHT, SwingUtilities.RIGHT
    };

    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_CLASS[columnIndex]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
