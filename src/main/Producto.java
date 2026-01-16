/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import util.*;

public class Producto implements java.io.Serializable {

//DECLARACIÓN DE ATRIBUTOS
    int id_producto = 0;
    String codigo = "";
    String codBarras = "";
    String nombre = "";
    String marca = "";
    String descripcion = "";
    double alicuota = 0.0;
    int proveedor = 0;
    int tipo = 0;
    int subtipo = 0;
    String familia = "";
    String linea = "";
    String unidad = "";
    double cantidad = 0.0;
    String codificacion = "";

//CONSTANTES RELACIONALES
    public static final String PRODUCTO_TABLA = "PRODUCTO";
    public static final String CAMPO_ID_PRODUCTO_TABLA = "ID_PRODUCTO";
    public static final String CAMPO_CODIGO_TABLA = "CODIGO";
    public static final String CAMPO_CODBARRAS_TABLA = "COD_BARRAS";
    public static final String CAMPO_NOMBRE_TABLA = "NOMBRE";
    public static final String CAMPO_MARCA_TABLA = "MARCA";
    public static final String CAMPO_DESCRIPCION_TABLA = "DESCRIPCION";
    public static final String CAMPO_ALICUOTA_TABLA = "ALICUOTA";
    public static final String CAMPO_PROVEEDOR_TABLA = "PROVEEDOR";
    public static final String CAMPO_TIPO_TABLA = "TIPO";
    public static final String CAMPO_SUBTIPO_TABLA = "SUBTIPO";
    public static final String CAMPO_FAMILIA_TABLA = "FAMILIA";
    public static final String CAMPO_LINEA_TABLA = "LINEA";
    public static final String CAMPO_UNIDAD_TABLA = "UNIDAD";
    public static final String CAMPO_CANTIDAD_TABLA = "CANTIDAD";
    public static final String CAMPO_CODIFICACION_TABLA = "ID_CODIFICACION";
    
    public Producto(){
        
    }

    public Producto(int id_producto, String codigo, String codBarras, String nombre, String marca, String descripcion, double alicuota, int proveedor, int tipo, int subtipo, String familia, String linea, String unidad, double cantidad, String codificacion) {
        this.id_producto = id_producto;
        this.codigo = codigo;
        this.codBarras = codBarras;
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.alicuota = alicuota;
        this.proveedor = proveedor;
        this.tipo = tipo;
        this.subtipo = subtipo;
        this.familia = familia;
        this.linea = linea;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.codificacion = codificacion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getAlicuota() {
        return alicuota;
    }

    public int getProveedor() {
        return proveedor;
    }

    public int getTipo() {
        return tipo;
    }

    public int getSubtipo() {
        return subtipo;
    }

    public String getFamilia() {
        return familia;
    }

    public String getLinea() {
        return linea;
    }

    public String getUnidad() {
        return unidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getCodificacion() {
        return codificacion;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setId_producto(String id_producto) throws Exception {
        this.id_producto = new Integer(id_producto).intValue();
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAlicuota(double alicuota) {
        this.alicuota = alicuota;
    }

    public void setAlicuota(String alicuota) throws Exception {
        this.alicuota = new Double(alicuota).doubleValue();
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public void setProveedor(String proveedor) throws Exception {
        this.proveedor = new Integer(proveedor).intValue();
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setTipo(String tipo) throws Exception {
        this.tipo = new Integer(tipo).intValue();
    }

    public void setSubtipo(int subtipo) {
        this.subtipo = subtipo;
    }

    public void setSubtipo(String subtipo) throws Exception {
        this.subtipo = new Integer(subtipo).intValue();
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setCantidad(String cantidad) throws Exception {
        this.cantidad = new Double(cantidad).doubleValue();
    }

    public void setCodificacion(String codificacion) {
        this.codificacion = codificacion;
    }
// GUARDAR EN LA BASE DE DATOS

    public synchronized void guardarEnBD(String usuario, String clave) throws Exception {
        AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);

        String consulta = "INSERT INTO " + PRODUCTO_TABLA + " VALUES( "
                + id_producto + ", '"
                + codigo + "', '"
                + codBarras + "', '"
                + nombre + "', '"
                + marca + "', '"
                + descripcion + "', "
                + alicuota + ", "
                + proveedor + ", "
                + tipo + ", "
                + subtipo + ", '"
                + familia + "', '"
                + linea + "', '"
                + unidad + "', "
                + cantidad + ", '"
                + codificacion + "')";

        datos.actualizar(consulta);
        datos.cerrar();

    }

    public synchronized void guardarEnBD() throws Exception {
        guardarEnBD("root", "admin");
    }

    public Producto actualizarBD(String usuario, String clave) throws Exception {
        AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);
        String consulta = "UPDATE " + PRODUCTO_TABLA + " SET \n";
        consulta += CAMPO_ID_PRODUCTO_TABLA + " = '" + getId_producto() + "', \n";
        consulta += CAMPO_CODIGO_TABLA + " = '" + getCodigo() + "', \n";
        consulta += CAMPO_CODBARRAS_TABLA + " = '" + getCodBarras() + "', \n";
        consulta += CAMPO_NOMBRE_TABLA + " = '" + getNombre() + "', \n";
        consulta += CAMPO_MARCA_TABLA + " = '" + getMarca() + "', \n";
        consulta += CAMPO_DESCRIPCION_TABLA + " = '" + getDescripcion() + "', \n";
        consulta += CAMPO_ALICUOTA_TABLA + " = '" + getAlicuota() + "', \n";
        consulta += CAMPO_PROVEEDOR_TABLA + " = '" + getProveedor() + "', \n";
        consulta += CAMPO_TIPO_TABLA + " = '" + getTipo() + "', \n";
        consulta += CAMPO_SUBTIPO_TABLA + " = '" + getSubtipo() + "', \n";
        consulta += CAMPO_FAMILIA_TABLA + " = '" + getFamilia() + "', \n";
        consulta += CAMPO_LINEA_TABLA + " = '" + getLinea() + "', \n";
        consulta += CAMPO_UNIDAD_TABLA + " = '" + getUnidad() + "', \n";
        consulta += CAMPO_CANTIDAD_TABLA + " = '" + getCantidad() + "', \n";
        consulta += CAMPO_CODIFICACION_TABLA + " = '" + getCodificacion() + "' \n";

        consulta += "WHERE " + CAMPO_ID_PRODUCTO_TABLA + " = '" + getId_producto() + "';";

        System.err.println(consulta);
        
        datos.actualizar(consulta);
        return this;
    }

// LEER DE LA BASE DE DATOS
    public static synchronized Producto[] leerBD(String restriccion, String usuario, String clave) {

        Producto productos[];
        java.util.ArrayList<Producto> vectorProductos = new java.util.ArrayList<>();

        try {
            AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);

            String consulta = "SELECT * FROM " + PRODUCTO_TABLA + " WHERE " + restriccion + ";";
            
            System.err.println(consulta);

            datos.consultar(consulta);

            while (datos.resultados.next()) {
                vectorProductos.add(new Producto(datos.resultados.getInt(CAMPO_ID_PRODUCTO_TABLA),
                        datos.resultados.getString(CAMPO_CODIGO_TABLA),
                        datos.resultados.getString(CAMPO_CODBARRAS_TABLA),
                        datos.resultados.getString(CAMPO_NOMBRE_TABLA),
                        datos.resultados.getString(CAMPO_MARCA_TABLA),
                        datos.resultados.getString(CAMPO_DESCRIPCION_TABLA),
                        datos.resultados.getDouble(CAMPO_ALICUOTA_TABLA),
                        datos.resultados.getInt(CAMPO_PROVEEDOR_TABLA),
                        datos.resultados.getInt(CAMPO_TIPO_TABLA),
                        datos.resultados.getInt(CAMPO_SUBTIPO_TABLA),
                        datos.resultados.getString(CAMPO_FAMILIA_TABLA),
                        datos.resultados.getString(CAMPO_LINEA_TABLA),
                        datos.resultados.getString(CAMPO_UNIDAD_TABLA),
                        datos.resultados.getDouble(CAMPO_CANTIDAD_TABLA),
                        datos.resultados.getString(CAMPO_CODIFICACION_TABLA)));
            }

            datos.cerrar();

            productos = new Producto[vectorProductos.size()];

            for (int i = 0; i < productos.length; i++) {
                productos[i] = ((Producto) vectorProductos.get(i));
            }

            vectorProductos.clear();

            return productos;

        } catch (Exception e) {
            System.err.println("Excepción leyendo de la BD: " + e.getMessage());
            return null;
        }
    }

    /**
     * Lee todas las instancias de la clase en la base de datos requiere la
     * validacion
     */
    public static synchronized Producto[] leerBD(String usuario, String clave) throws Exception {
        return leerBD("1=1", usuario, clave);
    }

    public static Producto leerProductoPorID(String idProducto, String usuario, String clave) throws Exception {
        Producto salida = leerBD(CAMPO_ID_PRODUCTO_TABLA + " = '" + idProducto + "'", usuario, clave)[0];
        return salida;
    }

    public static Producto[] leerProductoPorId_producto(String id_producto, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_ID_PRODUCTO_TABLA + " LIKE '%" + id_producto + "%'", usuario, clave);
        return salida;
    }

    public static Producto[] leerProductoPorCodigo(String codigo, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_CODIGO_TABLA + " LIKE '%" + codigo + "%'", usuario, clave);
        return salida;
    }

    public static Producto[] leerProductoPorCodBarras(String codBarras, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_CODBARRAS_TABLA + " LIKE '%" + codBarras + "%'", usuario, clave);
        return salida;
    }

    public static Producto[] leerProductoPorNombre(String nombre, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_NOMBRE_TABLA + " LIKE '%" + nombre + "%'", usuario, clave);
        return salida;
    }

    public static Producto[] leerProductoPorMarca(String marca, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_MARCA_TABLA + " LIKE '%" + marca + "%'", usuario, clave);
        return salida;
    }

    public static Producto[] leerProductoPorDescripcion(String descripcion, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_DESCRIPCION_TABLA + " LIKE '%" + descripcion + "%'", usuario, clave);
        return salida;
    }

    public static Producto[] leerProductoPorAlicuota(String alicuota, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_ALICUOTA_TABLA + " LIKE '%" + alicuota + "%'", usuario, clave);
        return salida;
    }

    public static Producto[] leerProductoPorProveedor(String proveedor, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_PROVEEDOR_TABLA + " LIKE '%" + proveedor + "%'", usuario, clave);
        return salida;
    }

    public static Producto[] leerProductoPorTipo(String tipo, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_TIPO_TABLA + " LIKE '%" + tipo + "%'", usuario, clave);
        return salida;
    }

    public static Producto[] leerProductoPorSubtipo(String subtipo, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_SUBTIPO_TABLA + " LIKE '%" + subtipo + "%'", usuario, clave);
        return salida;
    }

    public static Producto[] leerProductoPorFamilia(String familia, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_FAMILIA_TABLA + " LIKE '%" + familia + "%'", usuario, clave);
        return salida;
    }

    public static Producto[] leerProductoPorLinea(String linea, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_LINEA_TABLA + " LIKE '%" + linea + "%'", usuario, clave);
        return salida;
    }

    public static Producto[] leerProductoPorUnidad(String unidad, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_UNIDAD_TABLA + " LIKE '%" + unidad + "%'", usuario, clave);
        return salida;
    }

    public static Producto[] leerProductoPorCantidad(String cantidad, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_CANTIDAD_TABLA + " LIKE '%" + cantidad + "%'", usuario, clave);
        return salida;
    }

    public static Producto[] leerProductoPorCodificacion(String codificacion, String usuario, String clave) throws Exception {
        Producto[] salida = leerBD(CAMPO_CODIFICACION_TABLA + " LIKE '%" + codificacion + "%'", usuario, clave);
        return salida;
    }

    public static String seleccionarProducto(String prods, String usuario, String clave) {
        String cadena = "<SELECT NAME=\"" + prods + "\">\n";

        cadena += "<OPTION VALUE=\"\"> ---\n";
        Producto[] productos = leerBD("1=1 ORDER BY CODIGO", usuario, clave);

        for (int i = 0; i < productos.length; i++) {
            cadena += "<OPTION VALUE=\"" + productos[i].toStringArray()[0] + "\">"
                    + productos[i].toStringArray()[1] + "\n";
        }
        cadena += "</SELECT>";
        return cadena;
    }

    public static String seleccionarProducto(String prods, Producto[] productos) {
        String cadena = "<SELECT NAME=\"" + prods + "\">\n";

        for (int i = 0; i < productos.length; i++) {
            cadena += "<OPTION VALUE=\"" + productos[i].toStringArray()[0] + "\">"
                    + productos[i].toStringArray()[1] + "\n";
        }
        cadena += "</SELECT>";
        return cadena;
    }

    public String toString() {
        return "\nid_producto: " + id_producto
                + "\ncodigo: " + codigo
                + "\ncodBarras: " + codBarras
                + "\nnombre: " + nombre
                + "\nmarca: " + marca
                + "\ndescripcion: " + descripcion
                + "\nalicuota: " + alicuota
                + "\nproveedor: " + proveedor
                + "\ntipo: " + tipo
                + "\nsubtipo: " + subtipo
                + "\nfamilia: " + familia
                + "\nlinea: " + linea
                + "\nunidad: " + unidad
                + "\ncantidad: " + cantidad
                + "\ncodificacion: " + codificacion;
    }

    public String[] toStringArray() {

        String[] productoStringArray = {
            id_producto + "",
            codigo,
            codBarras,
            nombre,
            marca,
            descripcion,
            alicuota + "",
            proveedor + "",
            tipo + "",
            subtipo + "",
            familia,
            linea,
            unidad,
            cantidad + "",
            codificacion
        };

        return productoStringArray;
    }

    public static String[][] listarProductos(String nombre) {
        String[][] salida = new String[50][];

        AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");

        String consulta = "select codigo, nombre, familia, linea, (select pr.precio from precios pr\n"
                + "where pr.id_producto = p.id_producto and pr.id_lista_precio = 1) as precio,\n"
                + "(select pr.precio from precios pr\n"
                + "where pr.id_producto = p.id_producto and pr.id_lista_precio = 2) as precio_2,\n"
                + "(select pr.precio from precios pr\n"
                + "where pr.id_producto = p.id_producto and pr.id_lista_precio = 3) as precio_3\n"
                + "from producto p\n"
                + "where nombre like '%" + nombre + "%' "
                + "and activo = 1 "
                + "order by nombre";
        ArrayList<ArrayList<String>> tabla = new ArrayList();

        try {
            datos.consultar(consulta);

            while (datos.resultados.next()) {
                ArrayList<String> temp = new ArrayList();

                for (int i = 0; i < 7; i++) {
                    temp.add(datos.resultados.getString(i + 1));

                }
                tabla.add(temp);
            }

            salida = new String[tabla.size()][];

            for (int i = 0; i < tabla.size(); i++) {
                salida[i] = new String[tabla.get(i).size()];
                for (int j = 0; j < tabla.get(i).size(); j++) {
                    ArrayList<String> temp = tabla.get(i);
                    salida[i][j] = temp.get(j);
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }

        return salida;
    }
    
     public static String[][] listarProductos() {
        String[][] salida = new String[50][];

        AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");

        String consulta = "select codigo, nombre, familia, linea, (select pr.precio from precios pr\n"
                + "where pr.id_producto = p.id_producto and pr.id_lista_precio = 1) as precio,\n"
                + "(select pr.precio from precios pr\n"
                + "where pr.id_producto = p.id_producto and pr.id_lista_precio = 2) as precio_2,\n"
                + "(select pr.precio from precios pr\n"
                + "where pr.id_producto = p.id_producto and pr.id_lista_precio = 3) as precio_3\n"
                + "from producto p\n"
                + "where activo = 1 "
                + "order by nombre";
        ArrayList<ArrayList<String>> tabla = new ArrayList();

        try {
            datos.consultar(consulta);

            while (datos.resultados.next()) {
                ArrayList<String> temp = new ArrayList();

                for (int i = 0; i < 7; i++) {
                    temp.add(datos.resultados.getString(i + 1));

                }
                tabla.add(temp);
            }

            salida = new String[tabla.size()][];

            for (int i = 0; i < tabla.size(); i++) {
                salida[i] = new String[tabla.get(i).size()];
                for (int j = 0; j < tabla.get(i).size(); j++) {
                    ArrayList<String> temp = tabla.get(i);
                    salida[i][j] = temp.get(j);
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }

        return salida;
    }
    
    public static String[][] listarProductosIventario(String nombre) {
        String[][] salida = new String[10][];

        AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");

        String consulta = "select codigo, nombre, familia, linea, (select pr.precio from precios pr\n"
                + "where pr.id_producto = p.id_producto and pr.id_lista_precio = 1) as precio,\n"
                + "(select pr.precio from precios pr\n"
                + "where pr.id_producto = p.id_producto and pr.id_lista_precio = 2) as precio_2,\n"
                + "(select pr.precio from precios pr\n"
                + "where pr.id_producto = p.id_producto and pr.id_lista_precio = 3) as precio_3\n"
                + "from producto p\n"
                + "where nombre like '%" + nombre + "%' "
                + "order by nombre";
        
        System.err.println(consulta);
        ArrayList<ArrayList<String>> tabla = new ArrayList();

        try {
            datos.consultar(consulta);

            while (datos.resultados.next()) {
                ArrayList<String> temp = new ArrayList();

                for (int i = 0; i < 7; i++) {
                    temp.add(datos.resultados.getString(i + 1));

                }
                tabla.add(temp);
            }

            salida = new String[tabla.size()][];

            for (int i = 0; i < tabla.size(); i++) {
                salida[i] = new String[tabla.get(i).size()];
                for (int j = 0; j < tabla.get(i).size(); j++) {
                    ArrayList<String> temp = tabla.get(i);
                    salida[i][j] = temp.get(j);
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }

        return salida;
    }
    
    public static double getStockActual(int idProducto){
        double cant = 0;
        
        try {
            AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");
            
            String consulta = "select stock_actual from stock where id_producto = " + idProducto;
            
            datos.consultar(consulta);
            
            while(datos.resultados.next()){
                cant = datos.resultados.getDouble(1);
            }
            
            datos.cerrar();
        } catch (Exception e) {
        }
        
        return cant;
    }

    public static void main(String[] args) throws Exception {

        Producto[] producto = leerBD("root", "admin");

        for (int i = 0; i < producto.length; i++) {
       //     System.out.println(producto[i]);

        }

        listarProductosIventario("");
        
        System.out.println(getStockActual(7));
        
        String [][] prods = listarProductos();
        
        for (int i = 0; i < prods.length; i++) {
            for (int j = 0; j < prods[i].length; j++) {
                System.out.print(prods[i][j]);
                
            }
            System.out.println("");
        }
        System.out.println(prods.length);
    }
}
