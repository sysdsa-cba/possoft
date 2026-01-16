/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package possoft.gui;

import gui.CellRenderer;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import main.Producto;

/**
 *
 * @author xvr
 */
public class TablaProductos extends JTable {

    /*public TablaProductos() {

        this.setModel(new MTListarProductos(
                Producto.listarProductos(""),
                new String[]{
                    "Codigo", "Nombre", "Tipo", "Detalle", "Precio 1", "Precio 2", "Precio 3"
                }
        ));

        for (int i = 0; i < this.getColumnCount(); i++) {
            this.getColumnModel().getColumn(i).setCellRenderer(new CellRenderer());
            this.getColumnModel().getColumn(i).setPreferredWidth(MTListarProductos.ANCHOS[i]);

        }
    }
*/
    public TablaProductos(String nombre) {

        this.setModel(new MTListarProductos(
                Producto.listarProductos(nombre),
                new String[]{
                    "Codigo", "Nombre", "Tipo", "Detalle", "Precio 1", "Precio 2", "Precio 3"
                }
        ));

        for (int i = 0; i < this.getColumnCount(); i++) {
            this.getColumnModel().getColumn(i).setCellRenderer(new CellRenderer());
            this.getColumnModel().getColumn(i).setPreferredWidth(MTListarProductos.ANCHOS[i]);

        }
               
    }

    @Override
    public int getSelectedRow() {
        return super.getSelectedRow(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
/*
class MTListarProductos extends DefaultTableModel {

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
        100, 200, 110, 110, 60, 60, 60
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
*/