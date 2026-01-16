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
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
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
public class GUIDevolucion extends javax.swing.JFrame {
    
    public static ArrayList<JLabel> cods = new ArrayList();
    ArrayList<JLabel> nombres = new ArrayList();
    
    ArrayList<PrecioProd> preciosProd = new ArrayList();
    
    ArrayList<JTextField> cantidad = new ArrayList();
    
    ArrayList<JComboBox> precios = new ArrayList();
    
    ArrayList<JButton> botonMasCant = new ArrayList();
    ArrayList<JButton> botonMenosCant = new ArrayList();
    
    Fecha fecha = new Fecha();
    Hora hora = new Hora();
    
    int cantSel = 0;
//    public final static Color FONDO = new Color(255,204,0);
     public final static Color FONDO = new Color(248,118,98);

    /**
     * Creates new form GUIVentas
     */
    public GUIDevolucion() {
        initComponents();
        
        
        this.getContentPane().setBackground(FONDO);
        pNro.setBackground(FONDO);
        pNro1.setBackground(FONDO);
        pBotonesCant.setBackground(FONDO);
        pBotonesCant1.setBackground(FONDO);
        pCantidad.setBackground(FONDO);
        pCantidad1.setBackground(FONDO);
        pNombre.setBackground(FONDO);
        pNombre1.setBackground(FONDO);
        pPrecio.setBackground(FONDO);
        pPrecio1.setBackground(FONDO);        
        
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
            masTemp.setSize(40, 20);
            JButton menosTemp = new JButton("-");
            masTemp.setForeground(Color.GREEN);
            menosTemp.setForeground(Color.RED);
            masTemp.setFont(new java.awt.Font("Comic Sans MS", 3, 20));
            menosTemp.setFont(new java.awt.Font("Comic Sans MS", 3, 20));
            
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
//            SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 150, 1);
//            JSpinner spinner = new JSpinner(model);
            JTextField tCantidad = new JFormattedTextField("0");
            tCantidad.setSize(120, 23);
//            spinner.setSize(120, 23);
//            spinner.setFont(new java.awt.Font("Comic Sans MS", 1, 13));
            tCantidad.setFont(new java.awt.Font("Comic Sans MS", 1, 13));

//            JComponent editor = spinner.getEditor();
//            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor;
//            spinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
            tCantidad.setHorizontalAlignment(JLabel.CENTER);
            
//            spinner.addChangeListener(new ChangeListener() {
//                @Override
//                public void stateChanged(ChangeEvent e) {
//                    calcularTotal();
//                }
//            });
//            
//            cantidad.add(spinner);
//tCantidad.addChangeListener(new ChangeListener() {
//                @Override
//                public void stateChanged(ChangeEvent e) {
//                    calcularTotal();
//                }
//            });
            
            cantidad.add(tCantidad);
        }
        
        for (int i = 0; i < preciosProd.size(); i++) {
            JComboBox temp = new JComboBox();
            
            DefaultListCellRenderer listRenderer;
            listRenderer = new DefaultListCellRenderer();
            listRenderer.setHorizontalAlignment(DefaultListCellRenderer.RIGHT);
            temp.setRenderer(listRenderer);
            
            temp.setFont(new java.awt.Font("Comic Sans MS", 1, 13));
            
            temp.addItem(preciosProd.get(i).precio_1);
            temp.addItem(preciosProd.get(i).precio_2);
            temp.addItem(preciosProd.get(i).precio_3);
            
            precios.add(temp);
        }
        
        int heightFila = 38;
        int cantFilas = 7;
        int height = heightFila * cantFilas;

        ///  this.setPreferredSize(new Dimension(932, height));
        //     JOptionPane.showMessageDialog(this, this.getHeight() + "");
        pNro.setLayout(new GridLayout(cantFilas, 1, 0, 30));
        pNro.setPreferredSize(new Dimension(45, height));
        
        pNro1.setLayout(new GridLayout(cantFilas, 1, 0, 30));
        pNro1.setPreferredSize(new Dimension(45, height));
        
        pNombre.setLayout(new GridLayout(cantFilas, 1, 10, 30));
        pNombre.setPreferredSize(new Dimension(180, height));
        
        pNombre1.setLayout(new GridLayout(cantFilas, 1, 10, 30));
        pNombre1.setPreferredSize(new Dimension(180, height));
        
        pCantidad.setLayout(new GridLayout(cantFilas, 1, 10, 30));
        pCantidad.setPreferredSize(new Dimension(150, height));
        pCantidad1.setLayout(new GridLayout(cantFilas, 1, 10, 30));
        pCantidad1.setPreferredSize(new Dimension(150, height));
        
        pPrecio.setLayout(new GridLayout(cantFilas, 1, 10, 30));
        pPrecio.setPreferredSize(new Dimension(150, height));
        pPrecio1.setLayout(new GridLayout(cantFilas, 1, 10, 30));
        pPrecio1.setPreferredSize(new Dimension(150, height));
        
        pBotonesCant.setLayout(new GridLayout(cantFilas, 2, 10, 30));
        pBotonesCant.setPreferredSize(new Dimension(80, 40));
        pBotonesCant1.setLayout(new GridLayout(cantFilas, 2, 10, 30));
        pBotonesCant1.setPreferredSize(new Dimension(80, 40));
        
        pNro.add(new Titulo("#"));
        pNro1.add(new Titulo("#"));
        
        pNombre.add(new Titulo("Producto"));
        pNombre1.add(new Titulo("Producto"));
        
        pCantidad.add(new Titulo("Cantidad"));
        pCantidad1.add(new Titulo("Cantidad"));
        
        pPrecio.add(new Titulo("Precio"));
        pPrecio1.add(new Titulo("Precio"));
        //  pBotonesCant.add(new Titulo("Cant"));

        for (int i = 0; i < 6; i++) {
            
            pNro.add(cods.get(i));
            //jPanel1.add(new JLabel("CO_CHI"));
            pNombre.add(nombres.get(i));
            pCantidad.add(cantidad.get(i));
            pPrecio.add(precios.get(i));
            
        }
        for (int i = 6; i < 12; i++) {
            
            pNro1.add(cods.get(i));
            //jPanel1.add(new JLabel("CO_CHI"));
            pNombre1.add(nombres.get(i));
            pCantidad1.add(cantidad.get(i));
            pPrecio1.add(precios.get(i));
            
        }
        
        pBotonesCant.add(new JLabel(""));
        pBotonesCant.add(new JLabel(""));
        pBotonesCant1.add(new JLabel(""));
        pBotonesCant1.add(new JLabel(""));
        
        for (int i = 0; i < 6; i++) {
            pBotonesCant.add(botonMasCant.get(i));
            pBotonesCant.add(botonMenosCant.get(i));
        }
        
        for (int i = 6; i < 12; i++) {
            pBotonesCant1.add(botonMasCant.get(i));
            pBotonesCant1.add(botonMenosCant.get(i));
        }
        
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            
        } catch (Exception e) {
        }
        
        FlatLightLaf.setup();
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(255,204,153));
        this.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.BLACK);
        
        actualizarTablaProductos();
        
    }
    
    public void aumentarCant(int j) {
        String cant = cantidad.get(j).getText() + "";
        int nuevaCant = (Integer.parseInt(cant) + 1);
        cantidad.get(j).setText(nuevaCant+"");
        calcularTotal();
    }
    
    public void disminuirCant(int j) {
        String cant = cantidad.get(j).getText() + "";
        int parce = Integer.parseInt(cant);
        if (parce > 0) {
            int nuevaCant = (Integer.parseInt(cant) - 1);
            cantidad.get(j).setText(nuevaCant+"");
        }
        calcularTotal();
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
                total -= Double.parseDouble(cantidad.get(i).getText().toString())
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
        pNro1 = new javax.swing.JPanel();
        pNombre1 = new javax.swing.JPanel();
        pPrecio1 = new javax.swing.JPanel();
        pCantidad1 = new javax.swing.JPanel();
        pBotonesCant1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DEVOLUCIONES");
        setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lNro.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        lNro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lNro.setText("Nro");
        getContentPane().add(lNro, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 15, 66, -1));

        pNro.setPreferredSize(new java.awt.Dimension(66, 0));

        javax.swing.GroupLayout pNroLayout = new javax.swing.GroupLayout(pNro);
        pNro.setLayout(pNroLayout);
        pNroLayout.setHorizontalGroup(
            pNroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        pNroLayout.setVerticalGroup(
            pNroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        getContentPane().add(pNro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, 506));

        pNombre.setPreferredSize(new java.awt.Dimension(150, 0));

        javax.swing.GroupLayout pNombreLayout = new javax.swing.GroupLayout(pNombre);
        pNombre.setLayout(pNombreLayout);
        pNombreLayout.setHorizontalGroup(
            pNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );
        pNombreLayout.setVerticalGroup(
            pNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        getContentPane().add(pNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 70, 113, 506));

        pCantidad.setPreferredSize(new java.awt.Dimension(150, 0));

        javax.swing.GroupLayout pCantidadLayout = new javax.swing.GroupLayout(pCantidad);
        pCantidad.setLayout(pCantidadLayout);
        pCantidadLayout.setHorizontalGroup(
            pCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );
        pCantidadLayout.setVerticalGroup(
            pCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        getContentPane().add(pCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 70, 86, 506));

        pPrecio.setPreferredSize(new java.awt.Dimension(150, 0));

        javax.swing.GroupLayout pPrecioLayout = new javax.swing.GroupLayout(pPrecio);
        pPrecio.setLayout(pPrecioLayout);
        pPrecioLayout.setHorizontalGroup(
            pPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );
        pPrecioLayout.setVerticalGroup(
            pPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        getContentPane().add(pPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 97, 506));

        lFecha.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        lFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lFecha.setText("Fecha");
        getContentPane().add(lFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 16, 38, -1));

        tFecha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tFecha.setText("12/12/2022");
        getContentPane().add(tFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 13, 82, -1));

        lHora.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        lHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lHora.setText("Hora");
        getContentPane().add(lHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 16, 59, -1));

        tHora.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tHora.setText("11:00");
        getContentPane().add(tHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 13, 94, -1));

        tNro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tNro.setText("1");
        getContentPane().add(tNro, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 13, 63, -1));

        bAceptar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bAceptar.setText("ACEPTAR");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(bAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 626, 109, -1));

        tTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tTotal.setText("0.0");
        tTotal.setToolTipText("");
        getContentPane().add(tTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 630, 109, -1));

        bCalcular.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bCalcular.setText("TOTAL");
        bCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(bCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 629, 109, -1));

        bNuevaVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bNuevaVenta.setText("NUEVA");
        bNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevaVentaActionPerformed(evt);
            }
        });
        getContentPane().add(bNuevaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 626, 109, -1));

        javax.swing.GroupLayout pBotonesCantLayout = new javax.swing.GroupLayout(pBotonesCant);
        pBotonesCant.setLayout(pBotonesCantLayout);
        pBotonesCantLayout.setHorizontalGroup(
            pBotonesCantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        pBotonesCantLayout.setVerticalGroup(
            pBotonesCantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        getContentPane().add(pBotonesCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 70, 506));

        pNro1.setPreferredSize(new java.awt.Dimension(66, 0));

        javax.swing.GroupLayout pNro1Layout = new javax.swing.GroupLayout(pNro1);
        pNro1.setLayout(pNro1Layout);
        pNro1Layout.setHorizontalGroup(
            pNro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        pNro1Layout.setVerticalGroup(
            pNro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        getContentPane().add(pNro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 60, 506));

        pNombre1.setPreferredSize(new java.awt.Dimension(150, 0));

        javax.swing.GroupLayout pNombre1Layout = new javax.swing.GroupLayout(pNombre1);
        pNombre1.setLayout(pNombre1Layout);
        pNombre1Layout.setHorizontalGroup(
            pNombre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );
        pNombre1Layout.setVerticalGroup(
            pNombre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        getContentPane().add(pNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 70, 105, 506));

        pPrecio1.setPreferredSize(new java.awt.Dimension(150, 0));

        javax.swing.GroupLayout pPrecio1Layout = new javax.swing.GroupLayout(pPrecio1);
        pPrecio1.setLayout(pPrecio1Layout);
        pPrecio1Layout.setHorizontalGroup(
            pPrecio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );
        pPrecio1Layout.setVerticalGroup(
            pPrecio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        getContentPane().add(pPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 93, 506));

        pCantidad1.setPreferredSize(new java.awt.Dimension(150, 0));

        javax.swing.GroupLayout pCantidad1Layout = new javax.swing.GroupLayout(pCantidad1);
        pCantidad1.setLayout(pCantidad1Layout);
        pCantidad1Layout.setHorizontalGroup(
            pCantidad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );
        pCantidad1Layout.setVerticalGroup(
            pCantidad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        getContentPane().add(pCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 70, 86, 506));

        javax.swing.GroupLayout pBotonesCant1Layout = new javax.swing.GroupLayout(pBotonesCant1);
        pBotonesCant1.setLayout(pBotonesCant1Layout);
        pBotonesCant1Layout.setHorizontalGroup(
            pBotonesCant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pBotonesCant1Layout.setVerticalGroup(
            pBotonesCant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        getContentPane().add(pBotonesCant1, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 70, -1, 506));

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
//        JOptionPane.showMessageDialog(null, cantidad.size());
//        ArrayList<Integer> id_productos = new ArrayList();
        ArrayList<ItemVentas> items = new ArrayList();
        ArrayList<String> consultas = new ArrayList();
        
        for (int i = 0; i < preciosProd.size(); i++) {
            double cantidadItem = 0;
            double precioItem = 0;
            
            try {
                cantidadItem = Double.parseDouble(cantidad.get(i).getText().toString());
                precioItem = Double.parseDouble(precios.get(i).getSelectedItem().toString());
                
            } catch (NumberFormatException e) {
            }
            
            if (cantidadItem > 0) {
                
                ItemVentas item = new ItemVentas();
                String producto = nombres.get(i).getText();
                double precio = Double.parseDouble(precios.get(i).getSelectedItem().toString());
                double cant = Double.parseDouble(cantidad.get(i).getText().toString());
                
                System.out.print(producto + " ");
                System.out.print(precio + " ");
                System.out.print(cant + " ");
                System.out.println(precioItem * cantidadItem);
                
                total -= precioItem * cantidadItem;
                
                try {
                    int cod_producto = Producto.leerProductoPorNombre(nombres.get(i).getText(), "root", "admin")[0].getId_producto();
                    //id_productos.add(Producto.leerProductoPorNombre(nombres.get(i).getText(), "root", "admin")[0].getId_producto());
                    item.setRegistro(venta.getRegistro());
                    item.setArticulo(cod_producto + "");
                    item.setNombre(producto);
                    item.setCant(-cant);
                    item.setPrecio(-precio);
                    item.setFechaIng(fecha);
                    item.setFechaEgr(fecha);
                    item.setFechaPro(fecha);
                    item.setCodSuc(-1);
                    
                    String consulta = "update stock set stock_actual = stock_actual + "
                            + cant + " where id_producto = " + cod_producto + "; ";
                    
                    consultas.add(consulta);
                    
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
            venta.setCodsuc(-1);
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
        
        for (String consulta : consultas) {
            try {
                AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");
                
                datos.actualizar(consulta);
                
                datos.cerrar();
                
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        
        new Print().a();
        
        for (int i = 1; i < pCantidad.getComponentCount(); i++) {
            ((JTextField) pCantidad.getComponent(i)).setEnabled(false);
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
            ((JTextField) pCantidad.getComponent(i)).setText("0");
        }
        
        for (int i = 1; i < pCantidad1.getComponentCount(); i++) {
            ((JTextField) pCantidad1.getComponent(i)).setText("0");
        }
        
        for (int i = 1; i < pPrecio.getComponentCount(); i++) {
            ((JComboBox) pPrecio.getComponent(i)).setSelectedIndex(0);
        }
        
        for (int i = 1; i < pPrecio1.getComponentCount(); i++) {
            ((JComboBox) pPrecio1.getComponent(i)).setSelectedIndex(0);
        }
        
        bAceptar.setEnabled(true);
        
        for (int i = 1; i < pCantidad.getComponentCount(); i++) {
            ((JTextField) pCantidad.getComponent(i)).setEnabled(true);
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
                GUIDevolucion frame = new GUIDevolucion();
                frame.setVisible(true);
                frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
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
    private javax.swing.JPanel pBotonesCant1;
    private javax.swing.JPanel pCantidad;
    private javax.swing.JPanel pCantidad1;
    private javax.swing.JPanel pNombre;
    private javax.swing.JPanel pNombre1;
    private javax.swing.JPanel pNro;
    private javax.swing.JPanel pNro1;
    private javax.swing.JPanel pPrecio;
    private javax.swing.JPanel pPrecio1;
    private javax.swing.JTextField tFecha;
    private javax.swing.JTextField tHora;
    private javax.swing.JTextField tNro;
    private javax.swing.JTextField tTotal;
    // End of variables declaration//GEN-END:variables
}
