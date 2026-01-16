/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import util.*;

/**
 *
 * @author xvr
 */
public class ItemVentas {
    
   //DECLARACIÓN DE ATRIBUTOS
    boolean entregado = false;
    Fecha fechaEntrega;
    int codSuc = 0;
    int registro = 0;
    int sobre = 0;
    Fecha fechaIng;
    Fecha fechaEgr;
    Fecha fechaPro;
    int articulo = 0;
    String nombre = "";
    double cant = 0.0;
    double precio = 0.0;
    int lista = 0;
    double costo = 0.0;
    double total = 0.0;
    int caja = 0;
    double dtc = 0.0;
    double impInt = 0.0;
    double iva = 0.0;
    int repone = 0;
    double itc = 0.0;
    double tgo = 0.0;
    int id = 0;
    int pcaja = 0;
    String rubro = "";
    String marca = "";
    int tipo = ItemVentas.VENTA;

//CONSTANTES RELACIONALES
    public static final String ITEMVENTAS_TABLA = "ITEMVENTAS";
    public static final String CAMPO_ENTREGADO_TABLA = "ENTREGADO";
    public static final String CAMPO_FECHAENTREGA_TABLA = "FECHAENTREGA";
    public static final String CAMPO_CODSUC_TABLA = "CODSUC";
    public static final String CAMPO_REGISTRO_TABLA = "REGISTRO";
    public static final String CAMPO_SOBRE_TABLA = "SOBRE";
    public static final String CAMPO_FECHAING_TABLA = "FECHA_ING";
    public static final String CAMPO_FECHAEGR_TABLA = "FECHA_EGR";
    public static final String CAMPO_FECHAPRO_TABLA = "FECHA_PRO";
    public static final String CAMPO_ARTICULO_TABLA = "ARTICULO";
    public static final String CAMPO_NOMBRE_TABLA = "NOMBRE";
    public static final String CAMPO_CANT_TABLA = "CANT";
    public static final String CAMPO_PRECIO_TABLA = "PRECIO";
    public static final String CAMPO_LISTA_TABLA = "LISTA";
    public static final String CAMPO_COSTO_TABLA = "COSTO";
    public static final String CAMPO_TOTAL_TABLA = "TOTAL";
    public static final String CAMPO_CAJA_TABLA = "CAJA";
    public static final String CAMPO_DTC_TABLA = "DCTO";
    public static final String CAMPO_IMPINT_TABLA = "IMPINT";
    public static final String CAMPO_IVA_TABLA = "IVA";
    public static final String CAMPO_REPONE_TABLA = "REPONE";
    public static final String CAMPO_ITC_TABLA = "ITC";
    public static final String CAMPO_TGO_TABLA = "TGO";
    public static final String CAMPO_ID_TABLA = "ID";
    public static final String CAMPO_PCAJA_TABLA = "PCAJA";
    public static final String CAMPO_RUBRO_TABLA = "RUBRO";
    public static final String CAMPO_MARCA_TABLA = "MARCA";
    
    public static final int VENTA = 1;
    public static final int DEVOLUCION = -1;
    
    public ItemVentas(){
        
    }

    public ItemVentas(boolean entregado, Fecha fechaEntrega, int codSuc, int registro, int sobre, Fecha fechaIng, 
            Fecha fechaEgr, Fecha fechaPro, int articulo, String nombre, double cant, double precio, int lista, double costo, double total, int caja, double dtc, double impInt, double iva, int repone, double itc, double tgo, int id, int pcaja, String rubro, String marca) {
        this.entregado = entregado;
        this.fechaEntrega = fechaEntrega;
        this.codSuc = codSuc;
        this.registro = registro;
        this.sobre = sobre;
        this.fechaIng = fechaIng;
        this.fechaEgr = fechaEgr;
        this.fechaPro = fechaPro;
        this.articulo = articulo;
        this.nombre = nombre;
        this.cant = cant;
        this.precio = precio;
        this.lista = lista;
        this.costo = costo;
        this.total = total;
        this.caja = caja;
        this.dtc = dtc;
        this.impInt = impInt;
        this.iva = iva;
        this.repone = repone;
        this.itc = itc;
        this.tgo = tgo;
        this.id = id;
        this.pcaja = pcaja;
        this.rubro = rubro;
        this.marca = marca;
    }

    public boolean getEntregado() {
        return entregado;
    }

    public Fecha getFechaEntrega() {
        return fechaEntrega;
    }

    public int getCodSuc() {
        return codSuc;
    }

    public int getRegistro() {
        return registro;
    }

    public int getSobre() {
        return sobre;
    }

    public Fecha getFechaIng() {
        return fechaIng;
    }

    public Fecha getFechaEgr() {
        return fechaEgr;
    }

    public Fecha getFechaPro() {
        return fechaPro;
    }

    public String getArticulo() {
        return articulo+"";
    }

    public String getNombre() {
        return nombre;
    }

    public double getCant() {
        return cant;
    }

    public double getPrecio() {
        return precio;
    }

    public int getLista() {
        return lista;
    }

    public double getCosto() {
        return costo;
    }

    public double getTotal() {
        return total;
    }

    public int getCaja() {
        return caja;
    }

    public double getDtc() {
        return dtc;
    }

    public double getImpInt() {
        return impInt;
    }

    public double getIva() {
        return iva;
    }

    public int getRepone() {
        return repone;
    }

    public double getItc() {
        return itc;
    }

    public double getTgo() {
        return tgo;
    }

    public int getId() {
        return id;
    }

    public int getPcaja() {
        return pcaja;
    }

    public String getRubro() {
        return rubro;
    }

    public String getMarca() {
        return marca;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public void setEntregado(String entregado) throws Exception {
        this.entregado = new Boolean(entregado).booleanValue();
    }

    public void setFechaEntrega(Fecha fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) throws Exception {
        this.fechaEntrega = new Fecha(fechaEntrega);
    }

    public void setCodSuc(int codSuc) {
        this.codSuc = codSuc;
    }

    public void setCodSuc(String codSuc) throws Exception {
        this.codSuc = new Integer(codSuc).intValue();
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public void setRegistro(String registro) throws Exception {
        this.registro = new Integer(registro).intValue();
    }

    public void setSobre(int sobre) {
        this.sobre = sobre;
    }

    public void setSobre(String sobre) throws Exception {
        this.sobre = new Integer(sobre).intValue();
    }

    public void setFechaIng(Fecha fechaIng) {
        this.fechaIng = fechaIng;
    }

    public void setFechaIng(String fechaIng) throws Exception {
        this.fechaIng = new Fecha(fechaIng);
    }

    public void setFechaEgr(Fecha fechaEgr) {
        this.fechaEgr = fechaEgr;
    }

    public void setFechaEgr(String fechaEgr) throws Exception {
        this.fechaEgr = new Fecha(fechaEgr);
    }

    public void setFechaPro(Fecha fechaPro) {
        this.fechaPro = fechaPro;
    }

    public void setFechaPro(String fechaPro) throws Exception {
        this.fechaPro = new Fecha(fechaPro);
    }

    public void setArticulo(String articulo) {
        this.articulo = new Integer(articulo);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCant(double cant) {
        this.cant = cant;
    }

    public void setCant(String cant) throws Exception {
        this.cant = new Double(cant).doubleValue();
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setPrecio(String precio) throws Exception {
        this.precio = new Double(precio).doubleValue();
    }

    public void setLista(int lista) {
        this.lista = lista;
    }

    public void setLista(String lista) throws Exception {
        this.lista = new Integer(lista).intValue();
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setCosto(String costo) throws Exception {
        this.costo = new Double(costo).doubleValue();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTotal(String total) throws Exception {
        this.total = new Double(total).doubleValue();
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }

    public void setCaja(String caja) throws Exception {
        this.caja = new Integer(caja).intValue();
    }

    public void setDtc(double dtc) {
        this.dtc = dtc;
    }

    public void setDtc(String dtc) throws Exception {
        this.dtc = new Double(dtc).doubleValue();
    }

    public void setImpInt(double impInt) {
        this.impInt = impInt;
    }

    public void setImpInt(String impInt) throws Exception {
        this.impInt = new Double(impInt).doubleValue();
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void setIva(String iva) throws Exception {
        this.iva = new Double(iva).doubleValue();
    }

    public void setRepone(int repone) {
        this.repone = repone;
    }

    public void setRepone(String repone) throws Exception {
        this.repone = new Integer(repone).intValue();
    }

    public void setItc(double itc) {
        this.itc = itc;
    }

    public void setItc(String itc) throws Exception {
        this.itc = new Double(itc).doubleValue();
    }

    public void setTgo(double tgo) {
        this.tgo = tgo;
    }

    public void setTgo(String tgo) throws Exception {
        this.tgo = new Double(tgo).doubleValue();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(String id) throws Exception {
        this.id = new Integer(id).intValue();
    }

    public void setPcaja(int pcaja) {
        this.pcaja = pcaja;
    }

    public void setPcaja(String pcaja) throws Exception {
        this.pcaja = new Integer(pcaja).intValue();
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public int isEntregado(){
        if(entregado)
            return 1;
        return 0;
    }
// GUARDAR EN LA BASE DE DATOS

    public synchronized void guardarEnBD(String usuario, String clave) throws Exception {
        AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);

        String consulta = "INSERT INTO " + ITEMVENTAS_TABLA + " VALUES( '"
                + isEntregado() + "', '"
                + new Fecha() + "', "
                + codSuc + ", "
                + registro + ", "
                + sobre + ", '"
                + fechaIng + "', '"
                + fechaEgr + "', '"
                + fechaPro + "', '"
                + articulo + "', '"
                + nombre + "', "
                + cant + ", "
                + precio + ", "
                + lista + ", "
                + costo + ", "
                + total + ", "
                + caja + ", "
                + dtc + ", "
                + impInt + ", "
                + iva + ", "
                + repone + ", "
                + itc + ", "
                + tgo + ", "
                + id + ", "
                + pcaja + ", '"
                + rubro + "', '"
                + marca + "')";

        datos.actualizar(consulta);
        datos.cerrar();

    }

    public synchronized void guardarEnBD() throws Exception {
        guardarEnBD("root", "admin");
    }

    public ItemVentas actualizarBD(String usuario, String clave) throws Exception {
        AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);
        String consulta = "UPDATE " + ITEMVENTAS_TABLA + " SET \n";
        consulta += CAMPO_ENTREGADO_TABLA + " = '" + getEntregado() + "', \n";
        consulta += CAMPO_FECHAENTREGA_TABLA + " = '" + getFechaEntrega() + "', \n";
        consulta += CAMPO_CODSUC_TABLA + " = '" + getCodSuc() + "', \n";
        consulta += CAMPO_REGISTRO_TABLA + " = '" + getRegistro() + "', \n";
        consulta += CAMPO_SOBRE_TABLA + " = '" + getSobre() + "', \n";
        consulta += CAMPO_FECHAING_TABLA + " = '" + getFechaIng() + "', \n";
        consulta += CAMPO_FECHAEGR_TABLA + " = '" + getFechaEgr() + "', \n";
        consulta += CAMPO_FECHAPRO_TABLA + " = '" + getFechaPro() + "', \n";
        consulta += CAMPO_ARTICULO_TABLA + " = '" + getArticulo() + "', \n";
        consulta += CAMPO_NOMBRE_TABLA + " = '" + getNombre() + "', \n";
        consulta += CAMPO_CANT_TABLA + " = '" + getCant() + "', \n";
        consulta += CAMPO_PRECIO_TABLA + " = '" + getPrecio() + "', \n";
        consulta += CAMPO_LISTA_TABLA + " = '" + getLista() + "', \n";
        consulta += CAMPO_COSTO_TABLA + " = '" + getCosto() + "', \n";
        consulta += CAMPO_TOTAL_TABLA + " = '" + getTotal() + "', \n";
        consulta += CAMPO_CAJA_TABLA + " = '" + getCaja() + "', \n";
        consulta += CAMPO_DTC_TABLA + " = '" + getDtc() + "', \n";
        consulta += CAMPO_IMPINT_TABLA + " = '" + getImpInt() + "', \n";
        consulta += CAMPO_IVA_TABLA + " = '" + getIva() + "', \n";
        consulta += CAMPO_REPONE_TABLA + " = '" + getRepone() + "', \n";
        consulta += CAMPO_ITC_TABLA + " = '" + getItc() + "', \n";
        consulta += CAMPO_TGO_TABLA + " = '" + getTgo() + "', \n";
        consulta += CAMPO_ID_TABLA + " = '" + getId() + "', \n";
        consulta += CAMPO_PCAJA_TABLA + " = '" + getPcaja() + "', \n";
        consulta += CAMPO_RUBRO_TABLA + " = '" + getRubro() + "', \n";
        consulta += CAMPO_MARCA_TABLA + " = '" + getMarca() + "' \n";

        consulta += "WHERE " + CAMPO_ENTREGADO_TABLA + " = '" + getEntregado() + "';";

        datos.actualizar(consulta);
        return this;
    }

// LEER DE LA BASE DE DATOS
    public static synchronized ItemVentas[] leerBD(String restriccion, String usuario, String clave) {

        ItemVentas itemventass[];
        java.util.ArrayList<ItemVentas> vectorItemVentass = new java.util.ArrayList<>();

        try {
            AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);

            String consulta = "SELECT * FROM " + ITEMVENTAS_TABLA + " WHERE " + restriccion + ";";

            datos.consultar(consulta);

            while (datos.resultados.next()) {
                vectorItemVentass.add(new ItemVentas(datos.resultados.getBoolean(CAMPO_ENTREGADO_TABLA),
                        new Fecha().setFechaMySQL(datos.resultados.getString(CAMPO_FECHAENTREGA_TABLA)),
                        datos.resultados.getInt(CAMPO_CODSUC_TABLA),
                        datos.resultados.getInt(CAMPO_REGISTRO_TABLA),
                        datos.resultados.getInt(CAMPO_SOBRE_TABLA),
                        new Fecha().setFechaMySQL(datos.resultados.getString(CAMPO_FECHAING_TABLA)),
                        new Fecha().setFechaMySQL(datos.resultados.getString(CAMPO_FECHAEGR_TABLA)),
                        new Fecha().setFechaMySQL(datos.resultados.getString(CAMPO_FECHAPRO_TABLA)),
                        datos.resultados.getInt(CAMPO_ARTICULO_TABLA),
                        datos.resultados.getString(CAMPO_NOMBRE_TABLA),
                        datos.resultados.getDouble(CAMPO_CANT_TABLA),
                        datos.resultados.getDouble(CAMPO_PRECIO_TABLA),
                        datos.resultados.getInt(CAMPO_LISTA_TABLA),
                        datos.resultados.getDouble(CAMPO_COSTO_TABLA),
                        datos.resultados.getDouble(CAMPO_TOTAL_TABLA),
                        datos.resultados.getInt(CAMPO_CAJA_TABLA),
                        datos.resultados.getDouble(CAMPO_DTC_TABLA),
                        datos.resultados.getDouble(CAMPO_IMPINT_TABLA),
                        datos.resultados.getDouble(CAMPO_IVA_TABLA),
                        datos.resultados.getInt(CAMPO_REPONE_TABLA),
                        datos.resultados.getDouble(CAMPO_ITC_TABLA),
                        datos.resultados.getDouble(CAMPO_TGO_TABLA),
                        datos.resultados.getInt(CAMPO_ID_TABLA),
                        datos.resultados.getInt(CAMPO_PCAJA_TABLA),
                        datos.resultados.getString(CAMPO_RUBRO_TABLA),
                        datos.resultados.getString(CAMPO_MARCA_TABLA)));
            }

            datos.cerrar();

            itemventass = new ItemVentas[vectorItemVentass.size()];

            for (int i = 0; i < itemventass.length; i++) {
                itemventass[i] = ((ItemVentas) vectorItemVentass.get(i));
            }

            vectorItemVentass.clear();

            return itemventass;

        } catch (Exception e) {
            System.err.println("Excepción leyendo de la BD: " + e.getMessage());
            return null;
        }
    }

    /**
     * Lee todas las instancias de la clase en la base de datos requiere la
     * validacion
     */
    public static synchronized ItemVentas[] leerBD(String usuario, String clave) throws Exception {
        return leerBD("1=1", usuario, clave);
    }

    

    public static ItemVentas[] leerItemVentasPorEntregado(String entregado, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_ENTREGADO_TABLA + " LIKE '%" + entregado + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorFechaEntrega(String fechaEntrega, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_FECHAENTREGA_TABLA + " LIKE '%" + fechaEntrega + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorCodSuc(String codSuc, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_CODSUC_TABLA + " LIKE '%" + codSuc + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorRegistro(String registro, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_REGISTRO_TABLA + " LIKE '%" + registro + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorSobre(String sobre, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_SOBRE_TABLA + " LIKE '%" + sobre + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorFechaIng(String fechaIng, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_FECHAING_TABLA + " LIKE '%" + fechaIng + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorFechaEgr(String fechaEgr, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_FECHAEGR_TABLA + " LIKE '%" + fechaEgr + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorFechaPro(String fechaPro, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_FECHAPRO_TABLA + " LIKE '%" + fechaPro + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorArticulo(String articulo, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_ARTICULO_TABLA + " LIKE '%" + articulo + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorNombre(String nombre, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_NOMBRE_TABLA + " LIKE '%" + nombre + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorCant(String cant, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_CANT_TABLA + " LIKE '%" + cant + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorPrecio(String precio, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_PRECIO_TABLA + " LIKE '%" + precio + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorLista(String lista, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_LISTA_TABLA + " LIKE '%" + lista + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorCosto(String costo, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_COSTO_TABLA + " LIKE '%" + costo + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorTotal(String total, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_TOTAL_TABLA + " LIKE '%" + total + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorCaja(String caja, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_CAJA_TABLA + " LIKE '%" + caja + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorDtc(String dtc, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_DTC_TABLA + " LIKE '%" + dtc + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorImpInt(String impInt, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_IMPINT_TABLA + " LIKE '%" + impInt + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorIva(String iva, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_IVA_TABLA + " LIKE '%" + iva + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorRepone(String repone, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_REPONE_TABLA + " LIKE '%" + repone + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorItc(String itc, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_ITC_TABLA + " LIKE '%" + itc + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorTgo(String tgo, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_TGO_TABLA + " LIKE '%" + tgo + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorId(String id, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_ID_TABLA + " LIKE '%" + id + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorPcaja(String pcaja, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_PCAJA_TABLA + " LIKE '%" + pcaja + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorRubro(String rubro, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_RUBRO_TABLA + " LIKE '%" + rubro + "%'", usuario, clave);
        return salida;
    }

    public static ItemVentas[] leerItemVentasPorMarca(String marca, String usuario, String clave) throws Exception {
        ItemVentas[] salida = leerBD(CAMPO_MARCA_TABLA + " LIKE '%" + marca + "%'", usuario, clave);
        return salida;
    }

    public static String seleccionarItemVentas(String items, String usuario, String clave) {
        String cadena = "<SELECT NAME=\"" + items + "\">\n";

        cadena += "<OPTION VALUE=\"\"> ---\n";
        ItemVentas[] itemventass = leerBD("1=1 ORDER BY FECHAENTREGA", usuario, clave);

        for (int i = 0; i < itemventass.length; i++) {
            cadena += "<OPTION VALUE=\"" + itemventass[i].toStringArray()[0] + "\">"
                    + itemventass[i].toStringArray()[1] + "\n";
        }
        cadena += "</SELECT>";
        return cadena;
    }

    public static String seleccionarItemVentas(String items, ItemVentas[] itemventass) {
        String cadena = "<SELECT NAME=\"" + items + "\">\n";

        for (int i = 0; i < itemventass.length; i++) {
            cadena += "<OPTION VALUE=\"" + itemventass[i].toStringArray()[0] + "\">"
                    + itemventass[i].toStringArray()[1] + "\n";
        }
        cadena += "</SELECT>";
        return cadena;
    }

    public String toStringViejo() {
        return "\nentregado: " + entregado
                + "\nfechaEntrega: " + fechaEntrega
                + "\ncodSuc: " + codSuc
                + "\nregistro: " + registro
                + "\nsobre: " + sobre
                + "\nfechaIng: " + fechaIng
                + "\nfechaEgr: " + fechaEgr
                + "\nfechaPro: " + fechaPro
                + "\narticulo: " + articulo
                + "\nnombre: " + nombre
                + "\ncant: " + cant
                + "\nprecio: " + precio
                + "\nlista: " + lista
                + "\ncosto: " + costo
                + "\ntotal: " + total
                + "\ncaja: " + caja
                + "\ndtc: " + dtc
                + "\nimpInt: " + impInt
                + "\niva: " + iva
                + "\nrepone: " + repone
                + "\nitc: " + itc
                + "\ntgo: " + tgo
                + "\nid: " + id
                + "\npcaja: " + pcaja
                + "\nrubro: " + rubro
                + "\nmarca: " + marca;
    }
    
        public String toString() {
        return  "registro: " + registro
                
                + " articulo: " + articulo
                + " nombre: " + nombre
                + " cant: " + cant
                + " precio: " + precio
;
    }

    public String[] toStringArray() {

        String[] itemventasStringArray = {
            entregado + "",
            fechaEntrega + "",
            codSuc + "",
            registro + "",
            sobre + "",
            fechaIng + "",
            fechaEgr + "",
            fechaPro + "",
            articulo + "",
            nombre,
            cant + "",
            precio + "",
            lista + "",
            costo + "",
            total + "",
            caja + "",
            dtc + "",
            impInt + "",
            iva + "",
            repone + "",
            itc + "",
            tgo + "",
            id + "",
            pcaja + "",
            rubro,
            marca
        };

        return itemventasStringArray;
    }

    public static void main(String[] args) throws Exception {

        ItemVentas[] itemventas = leerBD("root", "admin");

        for (int i = 0; i < itemventas.length; i++) {
            System.out.println(itemventas[i]);

        }
    }
    
}
