/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package possoft.gui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import main.ItemVentas;
import main.Print;
import main.Producto;
import main.Ventas;
import util.AdaptadorJDBC;
import util.Fecha;
import util.Hora;
import util.RegistroActual;
import util.Util;
import main.PrecioProd;

/**
 *
 * @author xvr
 */
public class GUIVentasViejo extends javax.swing.JFrame {

    public static ArrayList<JLabel> cods = new ArrayList();
    ArrayList<JLabel> nombres = new ArrayList();

    ArrayList<PrecioProd> preciosProd = new ArrayList();

    ArrayList<JSpinner> cantidad = new ArrayList();

    ArrayList<JComboBox> precios = new ArrayList();

    ArrayList<JButton> botonMasCant = new ArrayList();
    ArrayList<JButton> botonMenosCant = new ArrayList();

    Fecha fecha = new Fecha();
    Hora hora = new Hora();

    int cantSel = 0;

    /**
     * Creates new form GUIVentas
     */
    public GUIVentasViejo() {
        initComponents();

        GregorianCalendar ahora = new GregorianCalendar();
        hora.setHoras(ahora.get(Calendar.HOUR_OF_DAY));
        hora.setMinutos(ahora.get(Calendar.MINUTE));

        tFecha.setText(fecha.getFecha());
        tHora.setText(hora.toString());

        tNro.setText(Ventas.getUltimoRegistro() + 1 + "");
        tNro.setEditable(false);

        Object[] items = {"precio 1", "precio 2", "precio 3"};

        try {

            AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");

            String consulta = "select p.id_producto, nombre, \n"
                    + "(select pr.precio from precios pr where pr.id_producto = p.id_producto and pr.id_lista_precio = 1) as precio_1,\n"
                    + "(select pr.precio from precios pr where pr.id_producto = p.id_producto and pr.id_lista_precio = 2) as precio_2,\n"
                    + "(select pr.precio from precios pr where pr.id_producto = p.id_producto and pr.id_lista_precio = 3) as precio_3\n"
                    + "from producto p\n"
                    + "where activo = 1 ";

            datos.consultar(consulta);

            while (datos.resultados.next()) {
                PrecioProd temp = new PrecioProd(datos.resultados.getInt(1),
                        datos.resultados.getString(2),
                        datos.resultados.getDouble(3),
                        datos.resultados.getDouble(4),
                        datos.resultados.getDouble(5));
                preciosProd.add(temp);
            }

        } catch (Exception e) {
        }

        System.out.println(preciosProd);

        for (int i = 0; i < preciosProd.size(); i++) {
            cods.add(new JLabel(preciosProd.get(i).idProducto + "", SwingConstants.CENTER));
        }

        for (int i = 0; i < preciosProd.size(); i++) {
            nombres.add(new JLabel(preciosProd.get(i).nombre));
        }

        for (int i = 0; i < preciosProd.size(); i++) {
            JButton masTemp = new JButton("+");
            JButton menosTemp = new JButton("-");
            masTemp.setForeground(Color.GREEN);
            menosTemp.setForeground(Color.RED);
            masTemp.setFont(new java.awt.Font("Comic Sans MS", 3, 12));
            menosTemp.setFont(new java.awt.Font("Comic Sans MS", 3, 12));

            int j = i;
            masTemp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // System.out.println(j);
                    aumentarCantidad(e, j);
                }
            });
            
            menosTemp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // System.out.println(j);
                    disminuirCantidad(e, j);
                }
            });

            botonMasCant.add(masTemp);
            botonMenosCant.add(menosTemp);
        }

        for (int i = 0; i < preciosProd.size(); i++) {
            SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 150, 1);
            JSpinner spinner = new JSpinner(model);
            spinner.setSize(120, 23);

            spinner.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    calcularTotal();
                }
            });

            cantidad.add(spinner);
        }

        for (int i = 0; i < preciosProd.size(); i++) {
            JComboBox temp = new JComboBox();

            temp.addItem(preciosProd.get(i).precio_1);
            temp.addItem(preciosProd.get(i).precio_2);
            temp.addItem(preciosProd.get(i).precio_3);

            precios.add(temp);
        }

        int heightFila = 38;
        int cantFilas = 13;
        int height = heightFila * cantFilas;
        

        pNro.setLayout(new GridLayout(cantFilas, 1));

        pNro.setPreferredSize(new Dimension(45, height));
        pNombre.setLayout(new GridLayout(cantFilas, 1));
        pNombre.setPreferredSize(new Dimension(180, height));
        pCantidad.setLayout(new GridLayout(cantFilas, 1));
        pCantidad.setPreferredSize(new Dimension(150, height));
        pPrecio.setLayout(new GridLayout(cantFilas, 1));
        pPrecio.setPreferredSize(new Dimension(150, height));
        pBotonesCant.setLayout(new GridLayout(cantFilas, 2));
        pBotonesCant.setPreferredSize(new Dimension(50, height));

        pNro.add(new Titulo("#"));
        pNombre.add(new Titulo("Producto"));
        pCantidad.add(new Titulo("Cantidad"));
        pPrecio.add(new Titulo("Precio"));
        //  pBotonesCant.add(new Titulo("Cant"));

        for (int i = 0; i < 12; i++) {

            pNro.add(cods.get(i));
            //jPanel1.add(new JLabel("CO_CHI"));
            pNombre.add(nombres.get(i));
            pCantidad.add(cantidad.get(i));
            pPrecio.add(precios.get(i));

        }
        pBotonesCant.add(new JLabel(""));
        pBotonesCant.add(new JLabel(""));

        for (int i = 0; i < 12; i++) {
            pBotonesCant.add(botonMasCant.get(i));
            pBotonesCant.add(botonMenosCant.get(i));
        }

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());

        } catch (Exception e) {
        }

        FlatLightLaf.setup();
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(23, 180, 252));
        this.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.WHITE);

        actualizarTablaProductos();

    }

    public void aumentarCant(int j) {
        String cant = cantidad.get(j).getValue() + "";
        int nuevaCant = (Integer.parseInt(cant) + 1);
        cantidad.get(j).setValue(nuevaCant);
    }

    public void disminuirCant(int j) {
        String cant = cantidad.get(j).getValue() + "";
        int parce = Integer.parseInt(cant);
        if (parce > 0) {
            int nuevaCant = (Integer.parseInt(cant) - 1);
            cantidad.get(j).setValue(nuevaCant);
        }
    }

    public void actualizarTablaProductos() {
        try {
            AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");

            String consulta = "select p.id_producto ,codigo, nombre \n"
                    + "from producto p \n"
                    + "where activo = 1\n"
                    + "order by nombre";

            datos.consultar(consulta);

            int cols = datos.resultados.getMetaData().getColumnCount();

            String[] titulos = new String[cols];

            /* for (int i = 0; i < cols; i++) {
                titulos[i] = datos.resultados.getMetaData().getColumnName(i + 1);
            }*/
            titulos = new String[]{"#", "Codigo", "Nombre", "Cantidad"};

            ArrayList<String[]> registros = new ArrayList<>();

            while (datos.resultados.next()) {
                String[] temp = new String[5];

                temp[0] = datos.resultados.getString(1);
                temp[1] = datos.resultados.getString(2);
                temp[2] = datos.resultados.getString(3);
                registros.add(temp);
            }

            Object[][] data = new Object[registros.size()][];

            for (int i = 0; i < data.length; i++) {
                data[i] = registros.get(i);
            }

            /*            tProductos.setModel(new javax.swing.table.DefaultTableModel(
                    data,
                    titulos
            ));

            tProductos.getColumnModel().getColumn(0).setPreferredWidth(10);
            tProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tProductos.getColumnModel().getColumn(2).setPreferredWidth(180);
            tProductos.getColumnModel().getColumn(3).setPreferredWidth(70);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(jLabel1.CENTER);
            tProductos.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
            //tProductos.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

            DefaultTableCellRenderer color = new DefaultTableCellRenderer();
            color.setBackground(new Color(23, 180, 252));
            color.setHorizontalAlignment(jLabel1.CENTER);
            color.setForeground(Color.WHITE);
            tProductos.getColumnModel().getColumn(3).setCellRenderer(color);

            jScrollPane1.setViewportView(tProductos);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void calcularTotal() {

        double total = 0;

        for (int i = 0; i < cantidad.size(); i++) {
            try {
                total += Double.parseDouble(cantidad.get(i).getValue().toString())
                        * Double.parseDouble(precios.get(i).getSelectedItem().toString());

            } catch (Exception e) {
                System.err.println(e);
            }

        }

        tTotal.setText(Util.formato(total));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lNro = new javax.swing.JLabel();
        pNro = new javax.swing.JPanel();
        pNombre = new javax.swing.JPanel();
        pCantidad = new javax.swing.JPanel();
        pPrecio = new javax.swing.JPanel();
        lFecha = new javax.swing.JLabel();
        tFecha = new javax.swing.JTextField();
        lHora = new javax.swing.JLabel();
        tHora = new javax.swing.JTextField();
        tNro = new javax.swing.JTextField();
        bAceptar = new javax.swing.JButton();
        tTotal = new javax.swing.JTextField();
        bCalcular = new javax.swing.JButton();
        bNuevaVenta = new javax.swing.JButton();
        pBotonesCant = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VENTAS");

        lNro.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        lNro.setText("Nro");

        pNro.setPreferredSize(new java.awt.Dimension(66, 0));

        javax.swing.GroupLayout pNroLayout = new javax.swing.GroupLayout(pNro);
        pNro.setLayout(pNroLayout);
        pNroLayout.setHorizontalGroup(
            pNroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );
        pNroLayout.setVerticalGroup(
            pNroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pNombre.setPreferredSize(new java.awt.Dimension(150, 0));

        javax.swing.GroupLayout pNombreLayout = new javax.swing.GroupLayout(pNombre);
        pNombre.setLayout(pNombreLayout);
        pNombreLayout.setHorizontalGroup(
            pNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pNombreLayout.setVerticalGroup(
            pNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pCantidad.setPreferredSize(new java.awt.Dimension(150, 0));

        javax.swing.GroupLayout pCantidadLayout = new javax.swing.GroupLayout(pCantidad);
        pCantidad.setLayout(pCantidadLayout);
        pCantidadLayout.setHorizontalGroup(
            pCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );
        pCantidadLayout.setVerticalGroup(
            pCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pPrecio.setPreferredSize(new java.awt.Dimension(150, 0));

        javax.swing.GroupLayout pPrecioLayout = new javax.swing.GroupLayout(pPrecio);
        pPrecio.setLayout(pPrecioLayout);
        pPrecioLayout.setHorizontalGroup(
            pPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );
        pPrecioLayout.setVerticalGroup(
            pPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lFecha.setText("Fecha");

        tFecha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tFecha.setText("12/12/2022");

        lHora.setText("Hora");

        tHora.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tHora.setText("11:00");

        tNro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tNro.setText("1");

        bAceptar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bAceptar.setText("ACEPTAR");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        tTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tTotal.setText("0.0");
        tTotal.setToolTipText("");

        bCalcular.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bCalcular.setText("TOTAL");
        bCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCalcularActionPerformed(evt);
            }
        });

        bNuevaVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bNuevaVenta.setText("NUEVA");
        bNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevaVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pBotonesCantLayout = new javax.swing.GroupLayout(pBotonesCant);
        pBotonesCant.setLayout(pBotonesCantLayout);
        pBotonesCantLayout.setHorizontalGroup(
            pBotonesCantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );
        pBotonesCantLayout.setVerticalGroup(
            pBotonesCantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lNro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pNro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tNro, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lHora, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tHora, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pBotonesCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNro)
                    .addComponent(lFecha)
                    .addComponent(tFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lHora)
                    .addComponent(tHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                        .addComponent(bAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bNuevaVenta)
                        .addGap(6, 6, 6))
                    .addComponent(pPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(pNro, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(pNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(pCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(pBotonesCant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCalcularActionPerformed
        // TODO add your handling code here:
        calcularTotal();
    }//GEN-LAST:event_bCalcularActionPerformed

    private void aumentarCantidad(java.awt.event.ActionEvent evt, int j) {
        aumentarCant(j);
    }
    
     private void disminuirCantidad(java.awt.event.ActionEvent evt, int j) {
         disminuirCant(j);
    }

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        // TODO add your handling code here:

        Ventas venta = new Ventas();
        venta.setRegistro(Integer.parseInt(tNro.getText()));
        double total = 0;

//        ArrayList<Integer> id_productos = new ArrayList();
        ArrayList<ItemVentas> items = new ArrayList();

        for (int i = 0; i < preciosProd.size(); i++) {
            double cantidadItem = 0;
            double precioItem = 0;

            try {
                cantidadItem = Double.parseDouble(cantidad.get(i).getValue().toString());
                precioItem = Double.parseDouble(precios.get(i).getSelectedItem().toString());

            } catch (NumberFormatException e) {
            }

            if (cantidadItem > 0) {

                ItemVentas item = new ItemVentas();
                String producto = nombres.get(i).getText();
                double precio = Double.parseDouble(precios.get(i).getSelectedItem().toString());
                double cant = Double.parseDouble(cantidad.get(i).getValue().toString());

                System.out.print(producto + " ");
                System.out.print(precio + " ");
                System.out.print(cant + " ");
                System.out.println(precioItem * cantidadItem);

                total += precioItem * cantidadItem;

                try {
                    int cod_producto = Producto.leerProductoPorNombre(nombres.get(i).getText(), "root", "admin")[0].getId_producto();
                    //id_productos.add(Producto.leerProductoPorNombre(nombres.get(i).getText(), "root", "admin")[0].getId_producto());
                    item.setRegistro(venta.getRegistro());
                    item.setArticulo(cod_producto + "");
                    item.setNombre(producto);
                    item.setCant(cant);
                    item.setPrecio(precio);
                    item.setFechaIng(fecha);
                    item.setFechaEgr(fecha);
                    item.setFechaPro(fecha);

                    items.add(item);
                } catch (Exception e) {
                    System.err.println(e);
                }

            }

        }
        venta.setTotal(total);

        try {
            venta.setFecha(new Fecha());
            venta.setHora(tHora.getText());
            venta.setFechavto(fecha);
            venta.setCliente(1);
        } catch (Exception e) {
            System.err.println(e);
        }

        tTotal.setText(total + "");

        try {
            venta.guardarEnBD();

            RegistroActual.actualizarRegistro(venta.getRegistro());

        } catch (Exception e) {
            System.err.println(e);
        }

        for (ItemVentas it : items) {
            try {
                it.guardarEnBD();
            } catch (Exception e) {
                System.err.println(e);

            }
        }

        new Print().a();

        for (int i = 1; i < pCantidad.getComponentCount(); i++) {
            ((JSpinner) pCantidad.getComponent(i)).setEnabled(false);
        }

        for (int i = 1; i < pPrecio.getComponentCount(); i++) {
            ((JComboBox) pPrecio.getComponent(i)).setEnabled(false);
        }

        bAceptar.setEnabled(false);

        renovar();
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevaVentaActionPerformed
        // TODO add your handling code here:
        renovar();
    }//GEN-LAST:event_bNuevaVentaActionPerformed

    public void renovar() {
        tNro.setText(Ventas.getUltimoRegistro() + 1 + "");
        tNro.setEditable(false);

        for (int i = 1; i < pCantidad.getComponentCount(); i++) {
            ((JSpinner) pCantidad.getComponent(i)).setValue(0);
        }

        for (int i = 1; i < pPrecio.getComponentCount(); i++) {
            ((JComboBox) pPrecio.getComponent(i)).setSelectedIndex(0);
        }

        bAceptar.setEnabled(true);

        for (int i = 1; i < pCantidad.getComponentCount(); i++) {
            ((JSpinner) pCantidad.getComponent(i)).setEnabled(true);
        }

        for (int i = 1; i < pPrecio.getComponentCount(); i++) {
            ((JComboBox) pPrecio.getComponent(i)).setEnabled(true);
        }

        tTotal.setText("$ 0,00");
    }

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
                new GUIVentasViejo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCalcular;
    private javax.swing.JButton bNuevaVenta;
    private javax.swing.JLabel lFecha;
    private javax.swing.JLabel lHora;
    private javax.swing.JLabel lNro;
    private javax.swing.JPanel pBotonesCant;
    private javax.swing.JPanel pCantidad;
    private javax.swing.JPanel pNombre;
    private javax.swing.JPanel pNro;
    private javax.swing.JPanel pPrecio;
    private javax.swing.JTextField tFecha;
    private javax.swing.JTextField tHora;
    private javax.swing.JTextField tNro;
    private javax.swing.JTextField tTotal;
    // End of variables declaration//GEN-END:variables
}
