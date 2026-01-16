/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import util.*;
import java.util.Arrays;

/**
 *
 * @author xvr
 */
public class Ventas {

//DECLARACIÓN DE ATRIBUTOS
    int codsuc = 0;
    int registro = 0;
    int factura = 0;
    Fecha fecha;
    Hora hora;
    String tipocomp = "";
    int tipocompf = 0;
    int cliente = 0;
    String nombre = "";
    String codiva = "";
    String cuit = "";
    String ingbru = "";
    double neto21 = 0.0;
    double neto105 = 0.0;
    double iva21 = 0.0;
    double iva105 = 0.0;
    double exento = 0.0;
    double total = 0.0;
    String vendedor = "";
    double dctoseña = 0.0;
    double caja = 0;
    double ctacte = 0.0;
    double itc = 0.0;
    double tgo = 0.0;
    double impint = 0.0;
    int pcaja = 0;
    String cae = "";
    String fvcae = "";
    double rectarjeta = 0.0;
    double dtogral = 0.0;
    Fecha fechavto;
    String notas = "";

//CONSTANTES RELACIONALES
    public static final String VENTAS_TABLA = "VENTAS";
    public static final String CAMPO_CODSUC_TABLA = "CODSUC";
    public static final String CAMPO_REGISTRO_TABLA = "REGISTRO";
    public static final String CAMPO_FACTURA_TABLA = "FACTURA";
    public static final String CAMPO_FECHA_TABLA = "FECHA";
    public static final String CAMPO_HORA_TABLA = "HORA";
    public static final String CAMPO_TIPOCOMP_TABLA = "TIPOCOMP";
    public static final String CAMPO_TIPOCOMPF_TABLA = "TIPOCOMPF";
    public static final String CAMPO_CLIENTE_TABLA = "CLIENTE";
    public static final String CAMPO_NOMBRE_TABLA = "NOMBRE";
    public static final String CAMPO_CODIVA_TABLA = "CODIVA";
    public static final String CAMPO_CUIT_TABLA = "CUIT";
    public static final String CAMPO_INGBRU_TABLA = "INGBRU";
    public static final String CAMPO_NETO21_TABLA = "NETO21";
    public static final String CAMPO_NETO105_TABLA = "NETO105";
    public static final String CAMPO_IVA21_TABLA = "IVA21";
    public static final String CAMPO_IVA105_TABLA = "IVA105";
    public static final String CAMPO_EXENTO_TABLA = "EXENTO";
    public static final String CAMPO_TOTAL_TABLA = "TOTAL";
    public static final String CAMPO_VENDEDOR_TABLA = "VENDEDOR";
    public static final String CAMPO_DCTOSEÑA_TABLA = "DCTOSEÑA";
    public static final String CAMPO_CAJA_TABLA = "CAJA";
    public static final String CAMPO_CTACTE_TABLA = "CTACTE";
    public static final String CAMPO_ITC_TABLA = "ITC";
    public static final String CAMPO_TGO_TABLA = "TGO";
    public static final String CAMPO_IMPINT_TABLA = "IMPINT";
    public static final String CAMPO_PCAJA_TABLA = "PCAJA";
    public static final String CAMPO_CAE_TABLA = "CAE";
    public static final String CAMPO_FVCAE_TABLA = "FVCAE";
    public static final String CAMPO_RECTARJETA_TABLA = "RECTARJETA";
    public static final String CAMPO_DTOGRAL_TABLA = "DTOGRAL";
    public static final String CAMPO_FECHAVTO_TABLA = "FECHAVTO";
    public static final String CAMPO_NOTAS_TABLA = "NOTAS";

    public Ventas() {

    }

    public Ventas(int codsuc, int registro, int factura, Fecha fecha, Hora hora, String tipocomp, int tipocompf, int cliente, String nombre, String codiva, String cuit, String ingbru, double neto21, double neto105, double iva21, double iva105, double exento, double total, String vendedor, double dctoseña, double caja, double ctacte, double itc, double tgo, double impint, int pcaja, String cae, String fvcae, double rectarjeta, double dtogral, Fecha fechavto, String notas) {
        this.codsuc = codsuc;
        this.registro = registro;
        this.factura = factura;
        this.fecha = fecha;
        this.hora = hora;
        this.tipocomp = tipocomp;
        this.tipocompf = tipocompf;
        this.cliente = cliente;
        this.nombre = nombre;
        this.codiva = codiva;
        this.cuit = cuit;
        this.ingbru = ingbru;
        this.neto21 = neto21;
        this.neto105 = neto105;
        this.iva21 = iva21;
        this.iva105 = iva105;
        this.exento = exento;
        this.total = total;
        this.vendedor = vendedor;
        this.dctoseña = dctoseña;
        this.caja = caja;
        this.ctacte = ctacte;
        this.itc = itc;
        this.tgo = tgo;
        this.impint = impint;
        this.pcaja = pcaja;
        this.cae = cae;
        this.fvcae = fvcae;
        this.rectarjeta = rectarjeta;
        this.dtogral = dtogral;
        this.fechavto = fechavto;
        this.notas = notas;
    }

    public int getCodsuc() {
        return codsuc;
    }

    public int getRegistro() {
        return registro;
    }

    public int getFactura() {
        return factura;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Hora getHora() {
        return hora;
    }

    public String getTipocomp() {
        return tipocomp;
    }

    public int getTipocompf() {
        return tipocompf;
    }

    public int getCliente() {
        return cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodiva() {
        return codiva;
    }

    public String getCuit() {
        return cuit;
    }

    public String getIngbru() {
        return ingbru;
    }

    public double getNeto21() {
        return neto21;
    }

    public double getNeto105() {
        return neto105;
    }

    public double getIva21() {
        return iva21;
    }

    public double getIva105() {
        return iva105;
    }

    public double getExento() {
        return exento;
    }

    public double getTotal() {
        return total;
    }

    public String getVendedor() {
        return vendedor;
    }

    public double getDctoseña() {
        return dctoseña;
    }

    public double getCaja() {
        return caja;
    }

    public double getCtacte() {
        return ctacte;
    }

    public double getItc() {
        return itc;
    }

    public double getTgo() {
        return tgo;
    }

    public double getImpint() {
        return impint;
    }

    public int getPcaja() {
        return pcaja;
    }

    public String getCae() {
        return cae;
    }

    public String getFvcae() {
        return fvcae;
    }

    public double getRectarjeta() {
        return rectarjeta;
    }

    public double getDtogral() {
        return dtogral;
    }

    public Fecha getFechavto() {
        return fechavto;
    }

    public String getNotas() {
        return notas;
    }

    public void setCodsuc(int codsuc) {
        this.codsuc = codsuc;
    }

    public void setCodsuc(String codsuc) throws Exception {
        this.codsuc = new Integer(codsuc);
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public void setRegistro(String registro) throws Exception {
        this.registro = new Integer(registro);
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public void setFactura(String factura) throws Exception {
        this.factura = new Integer(factura).intValue();
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public void setFecha(String fecha) throws Exception {
        this.fecha = new Fecha(fecha);
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public void setHora(String hora) throws Exception {
        this.hora = new Hora(hora);
    }

    public void setTipocomp(String tipocomp) {
        this.tipocomp = tipocomp;
    }

    public void setTipocompf(int tipocompf) {
        this.tipocompf = tipocompf;
    }

    public void setTipocompf(String tipocompf) throws Exception {
        this.tipocompf = new Integer(tipocompf).intValue();
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public void setCliente(String cliente) throws Exception {
        this.cliente = new Integer(cliente).intValue();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodiva(String codiva) {
        this.codiva = codiva;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setIngbru(String ingbru) {
        this.ingbru = ingbru;
    }

    public void setNeto21(double neto21) {
        this.neto21 = neto21;
    }

    public void setNeto21(String neto21) throws Exception {
        this.neto21 = new Double(neto21).doubleValue();
    }

    public void setNeto105(double neto105) {
        this.neto105 = neto105;
    }

    public void setNeto105(String neto105) throws Exception {
        this.neto105 = new Double(neto105).doubleValue();
    }

    public void setIva21(double iva21) {
        this.iva21 = iva21;
    }

    public void setIva21(String iva21) throws Exception {
        this.iva21 = new Double(iva21).doubleValue();
    }

    public void setIva105(double iva105) {
        this.iva105 = iva105;
    }

    public void setIva105(String iva105) throws Exception {
        this.iva105 = new Double(iva105).doubleValue();
    }

    public void setExento(double exento) {
        this.exento = exento;
    }

    public void setExento(String exento) throws Exception {
        this.exento = new Double(exento).doubleValue();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTotal(String total) throws Exception {
        this.total = new Double(total).doubleValue();
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public void setDctoseña(double dctoseña) {
        this.dctoseña = dctoseña;
    }

    public void setDctoseña(String dctoseña) throws Exception {
        this.dctoseña = new Double(dctoseña);
    }

    public void setCaja(double caja) {
        this.caja = caja;
    }

    public void setCaja(String caja) throws Exception {
        this.caja = new Double(caja);
    }

    public void setCtacte(double ctacte) {
        this.ctacte = ctacte;
    }

    public void setCtacte(String ctacte) throws Exception {
        this.ctacte = new Double(ctacte).doubleValue();
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

    public void setImpint(double impint) {
        this.impint = impint;
    }

    public void setImpint(String impint) throws Exception {
        this.impint = new Double(impint).doubleValue();
    }

    public void setPcaja(int pcaja) {
        this.pcaja = pcaja;
    }

    public void setPcaja(String pcaja) throws Exception {
        this.pcaja = new Integer(pcaja).intValue();
    }

    public void setCae(String cae) {
        this.cae = cae;
    }

    public void setFvcae(String fvcae) {
        this.fvcae = fvcae;
    }

    public void setRectarjeta(double rectarjeta) {
        this.rectarjeta = rectarjeta;
    }

    public void setRectarjeta(String rectarjeta) throws Exception {
        this.rectarjeta = new Double(rectarjeta).doubleValue();
    }

    public void setDtogral(double dtogral) {
        this.dtogral = dtogral;
    }

    public void setDtogral(String dtogral) throws Exception {
        this.dtogral = new Double(dtogral).doubleValue();
    }

    public void setFechavto(Fecha fechavto) {
        this.fechavto = fechavto;
    }

    public void setFechavto(String fechavto) throws Exception {
        this.fechavto = new Fecha(fechavto);
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
// GUARDAR EN LA BASE DE DATOS

    public synchronized void guardarEnBD(String usuario, String clave) throws Exception {
        AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);

        String consulta = "INSERT INTO " + VENTAS_TABLA + " VALUES( "
                + codsuc + ", "
                + registro + ", "
                + factura + ", '"
                + fecha.getFechaMySQL() + "', '"
                + fecha.getFechaMySQL() + " " + hora + "', '"
                + tipocomp + "', "
                + tipocompf + ", "
                + cliente + ", '"
                + nombre + "', '"
                + codiva + "', '"
                + cuit + "', '"
                + ingbru + "', "
                + neto21 + ", "
                + neto105 + ", "
                + iva21 + ", "
                + iva105 + ", "
                + exento + ", "
                + total + ", '"
                + vendedor + "', "
                + dctoseña + ", "
                + caja + ", "
                + ctacte + ", "
                + itc + ", "
                + tgo + ", "
                + impint + ", "
                + pcaja + ", '"
                + cae + "', '"
                + fvcae + "', "
                + rectarjeta + ", "
                + dtogral + ", '"
                + fechavto.getFechaMySQL() + "', '"
                + notas + "')";

        datos.actualizar(consulta);
        datos.cerrar();

    }

    public synchronized void guardarEnBD() throws Exception {
        guardarEnBD("root", "admin");
    }

    public Ventas actualizarBD(String usuario, String clave) throws Exception {
        AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);
        String consulta = "UPDATE " + VENTAS_TABLA + " SET \n";
        consulta += CAMPO_CODSUC_TABLA + " = '" + getCodsuc() + "', \n";
        //   consulta += CAMPO_REGISTRO_TABLA + " = '" + getRegistro() + "', \n";
        consulta += CAMPO_FACTURA_TABLA + " = '" + getFactura() + "', \n";
        consulta += CAMPO_FECHA_TABLA + " = '" + getFecha() + "', \n";
        consulta += CAMPO_HORA_TABLA + " = '" + getHora() + "', \n";
        consulta += CAMPO_TIPOCOMP_TABLA + " = '" + getTipocomp() + "', \n";
        consulta += CAMPO_TIPOCOMPF_TABLA + " = '" + getTipocompf() + "', \n";
        consulta += CAMPO_CLIENTE_TABLA + " = '" + getCliente() + "', \n";
        consulta += CAMPO_NOMBRE_TABLA + " = '" + getNombre() + "', \n";
        consulta += CAMPO_CODIVA_TABLA + " = '" + getCodiva() + "', \n";
        consulta += CAMPO_CUIT_TABLA + " = '" + getCuit() + "', \n";
        consulta += CAMPO_INGBRU_TABLA + " = '" + getIngbru() + "', \n";
        consulta += CAMPO_NETO21_TABLA + " = '" + getNeto21() + "', \n";
        consulta += CAMPO_NETO105_TABLA + " = '" + getNeto105() + "', \n";
        consulta += CAMPO_IVA21_TABLA + " = '" + getIva21() + "', \n";
        consulta += CAMPO_IVA105_TABLA + " = '" + getIva105() + "', \n";
        consulta += CAMPO_EXENTO_TABLA + " = '" + getExento() + "', \n";
        consulta += CAMPO_TOTAL_TABLA + " = '" + getTotal() + "', \n";
        consulta += CAMPO_VENDEDOR_TABLA + " = '" + getVendedor() + "', \n";
        consulta += CAMPO_DCTOSEÑA_TABLA + " = '" + getDctoseña() + "', \n";
        consulta += CAMPO_CAJA_TABLA + " = '" + getCaja() + "', \n";
        consulta += CAMPO_CTACTE_TABLA + " = '" + getCtacte() + "', \n";
        consulta += CAMPO_ITC_TABLA + " = '" + getItc() + "', \n";
        consulta += CAMPO_TGO_TABLA + " = '" + getTgo() + "', \n";
        consulta += CAMPO_IMPINT_TABLA + " = '" + getImpint() + "', \n";
        consulta += CAMPO_PCAJA_TABLA + " = '" + getPcaja() + "', \n";
        consulta += CAMPO_CAE_TABLA + " = '" + getCae() + "', \n";
        consulta += CAMPO_FVCAE_TABLA + " = '" + getFvcae() + "', \n";
        consulta += CAMPO_RECTARJETA_TABLA + " = '" + getRectarjeta() + "', \n";
        consulta += CAMPO_DTOGRAL_TABLA + " = '" + getDtogral() + "', \n";
        consulta += CAMPO_FECHAVTO_TABLA + " = '" + getFechavto() + "', \n";
        consulta += CAMPO_NOTAS_TABLA + " = '" + getNotas() + "' \n";

        consulta += "WHERE " + CAMPO_REGISTRO_TABLA + " = '" + getRegistro() + "';";

        System.err.println(consulta);
        datos.actualizar(consulta);
        return this;
    }

// LEER DE LA BASE DE DATOS
    public static synchronized Ventas[] leerBD(String restriccion, String usuario, String clave) {

        Ventas ventass[];
        java.util.ArrayList<Ventas> vectorVentass = new java.util.ArrayList<>();

        try {
            AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);

            String consulta = "SELECT * FROM " + VENTAS_TABLA + " WHERE " + restriccion + ";";

            datos.consultar(consulta);

            while (datos.resultados.next()) {
                vectorVentass.add(new Ventas(datos.resultados.getInt(CAMPO_CODSUC_TABLA),
                        datos.resultados.getInt(CAMPO_REGISTRO_TABLA),
                        datos.resultados.getInt(CAMPO_FACTURA_TABLA),
                        new Fecha().setFechaMySQL(datos.resultados.getString(CAMPO_FECHA_TABLA)),
                        new Hora(datos.resultados.getString(CAMPO_HORA_TABLA)),
                        datos.resultados.getString(CAMPO_TIPOCOMP_TABLA),
                        datos.resultados.getInt(CAMPO_TIPOCOMPF_TABLA),
                        datos.resultados.getInt(CAMPO_CLIENTE_TABLA),
                        datos.resultados.getString(CAMPO_NOMBRE_TABLA),
                        datos.resultados.getString(CAMPO_CODIVA_TABLA),
                        datos.resultados.getString(CAMPO_CUIT_TABLA),
                        datos.resultados.getString(CAMPO_INGBRU_TABLA),
                        datos.resultados.getDouble(CAMPO_NETO21_TABLA),
                        datos.resultados.getDouble(CAMPO_NETO105_TABLA),
                        datos.resultados.getDouble(CAMPO_IVA21_TABLA),
                        datos.resultados.getDouble(CAMPO_IVA105_TABLA),
                        datos.resultados.getDouble(CAMPO_EXENTO_TABLA),
                        datos.resultados.getDouble(CAMPO_TOTAL_TABLA),
                        datos.resultados.getString(CAMPO_VENDEDOR_TABLA),
                        datos.resultados.getDouble(CAMPO_DCTOSEÑA_TABLA),
                        datos.resultados.getDouble(CAMPO_CAJA_TABLA),
                        datos.resultados.getDouble(CAMPO_CTACTE_TABLA),
                        datos.resultados.getDouble(CAMPO_ITC_TABLA),
                        datos.resultados.getDouble(CAMPO_TGO_TABLA),
                        datos.resultados.getDouble(CAMPO_IMPINT_TABLA),
                        datos.resultados.getInt(CAMPO_PCAJA_TABLA),
                        datos.resultados.getString(CAMPO_CAE_TABLA),
                        datos.resultados.getString(CAMPO_FVCAE_TABLA),
                        datos.resultados.getDouble(CAMPO_RECTARJETA_TABLA),
                        datos.resultados.getDouble(CAMPO_DTOGRAL_TABLA),
                        new Fecha().setFechaMySQL(datos.resultados.getString(CAMPO_FECHAVTO_TABLA)),
                        datos.resultados.getString(CAMPO_NOTAS_TABLA)));
            }

            datos.cerrar();

            ventass = new Ventas[vectorVentass.size()];

            for (int i = 0; i < ventass.length; i++) {
                ventass[i] = ((Ventas) vectorVentass.get(i));
            }

            vectorVentass.clear();

            return ventass;

        } catch (Exception e) {
            System.err.println("Excepción leyendo de la BD: " + e.getMessage());
            return null;
        }
    }

    /**
     * Lee todas las instancias de la clase en la base de datos requiere la
     * validacion
     */
    public static synchronized Ventas[] leerBD(String usuario, String clave) throws Exception {
        return leerBD("1=1", usuario, clave);
    }

    /* public static Ventas leerVentasPorID(String idVentas, String usuario, String clave) throws Exception {
        Ventas salida = leerBD(CAMPO_IDVENTAS_TABLA + " = '" + idVentas + "'", usuario, clave)[0];
        return salida;
    }*/
    public static Ventas[] leerVentasPorCodsuc(String codsuc, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_CODSUC_TABLA + " LIKE '%" + codsuc + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorRegistro(String registro, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_REGISTRO_TABLA + " LIKE '%" + registro + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorFactura(String factura, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_FACTURA_TABLA + " LIKE '%" + factura + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorFecha(String fecha, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_FECHA_TABLA + " LIKE '%" + fecha + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorHora(String hora, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_HORA_TABLA + " LIKE '%" + hora + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorTipocomp(String tipocomp, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_TIPOCOMP_TABLA + " LIKE '%" + tipocomp + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorTipocompf(String tipocompf, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_TIPOCOMPF_TABLA + " LIKE '%" + tipocompf + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorCliente(String cliente, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_CLIENTE_TABLA + " LIKE '%" + cliente + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorNombre(String nombre, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_NOMBRE_TABLA + " LIKE '%" + nombre + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorCodiva(String codiva, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_CODIVA_TABLA + " LIKE '%" + codiva + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorCuit(String cuit, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_CUIT_TABLA + " LIKE '%" + cuit + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorIngbru(String ingbru, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_INGBRU_TABLA + " LIKE '%" + ingbru + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorNeto21(String neto21, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_NETO21_TABLA + " LIKE '%" + neto21 + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorNeto105(String neto105, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_NETO105_TABLA + " LIKE '%" + neto105 + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorIva21(String iva21, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_IVA21_TABLA + " LIKE '%" + iva21 + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorIva105(String iva105, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_IVA105_TABLA + " LIKE '%" + iva105 + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorExento(String exento, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_EXENTO_TABLA + " LIKE '%" + exento + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorTotal(String total, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_TOTAL_TABLA + " LIKE '%" + total + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorVendedor(String vendedor, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_VENDEDOR_TABLA + " LIKE '%" + vendedor + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorDctoseña(String dctoseña, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_DCTOSEÑA_TABLA + " LIKE '%" + dctoseña + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorCaja(String caja, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_CAJA_TABLA + " LIKE '%" + caja + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorCtacte(String ctacte, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_CTACTE_TABLA + " LIKE '%" + ctacte + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorItc(String itc, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_ITC_TABLA + " LIKE '%" + itc + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorTgo(String tgo, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_TGO_TABLA + " LIKE '%" + tgo + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorImpint(String impint, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_IMPINT_TABLA + " LIKE '%" + impint + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorPcaja(String pcaja, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_PCAJA_TABLA + " LIKE '%" + pcaja + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorCae(String cae, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_CAE_TABLA + " LIKE '%" + cae + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorFvcae(String fvcae, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_FVCAE_TABLA + " LIKE '%" + fvcae + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorRectarjeta(String rectarjeta, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_RECTARJETA_TABLA + " LIKE '%" + rectarjeta + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorDtogral(String dtogral, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_DTOGRAL_TABLA + " LIKE '%" + dtogral + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorFechavto(String fechavto, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_FECHAVTO_TABLA + " LIKE '%" + fechavto + "%'", usuario, clave);
        return salida;
    }

    public static Ventas[] leerVentasPorNotas(String notas, String usuario, String clave) throws Exception {
        Ventas[] salida = leerBD(CAMPO_NOTAS_TABLA + " LIKE '%" + notas + "%'", usuario, clave);
        return salida;
    }

    public static String seleccionarVentas(String vents, String usuario, String clave) {
        String cadena = "<SELECT NAME=\"" + vents + "\">\n";

        cadena += "<OPTION VALUE=\"\"> ---\n";
        Ventas[] ventass = leerBD("1=1 ORDER BY REGISTRO", usuario, clave);

        for (int i = 0; i < ventass.length; i++) {
            cadena += "<OPTION VALUE=\"" + ventass[i].toStringArray()[0] + "\">"
                    + ventass[i].toStringArray()[1] + "\n";
        }
        cadena += "</SELECT>";
        return cadena;
    }

    public static String seleccionarVentas(String vents, Ventas[] ventass) {
        String cadena = "<SELECT NAME=\"" + vents + "\">\n";

        for (int i = 0; i < ventass.length; i++) {
            cadena += "<OPTION VALUE=\"" + ventass[i].toStringArray()[0] + "\">"
                    + ventass[i].toStringArray()[1] + "\n";
        }
        cadena += "</SELECT>";
        return cadena;
    }

    public String toString() {
        return "\ncodsuc: " + codsuc
                + "\nregistro: " + registro
                + "\nfactura: " + factura
                + "\nfecha: " + fecha
                + "\nhora: " + hora
                + "\ntipocomp: " + tipocomp
                + "\ntipocompf: " + tipocompf
                + "\ncliente: " + cliente
                + "\nnombre: " + nombre
                + "\ncodiva: " + codiva
                + "\ncuit: " + cuit
                + "\ningbru: " + ingbru
                + "\nneto21: " + neto21
                + "\nneto105: " + neto105
                + "\niva21: " + iva21
                + "\niva105: " + iva105
                + "\nexento: " + exento
                + "\ntotal: " + total
                + "\nvendedor: " + vendedor
                + "\ndctoseña: " + dctoseña
                + "\ncaja: " + caja
                + "\nctacte: " + ctacte
                + "\nitc: " + itc
                + "\ntgo: " + tgo
                + "\nimpint: " + impint
                + "\npcaja: " + pcaja
                + "\ncae: " + cae
                + "\nfvcae: " + fvcae
                + "\nrectarjeta: " + rectarjeta
                + "\ndtogral: " + dtogral
                + "\nfechavto: " + fechavto
                + "\nnotas: " + notas;
    }

    public String[] toStringArray() {

        String[] ventasStringArray = {
            codsuc + "",
            registro + "",
            factura + "",
            fecha + "",
            hora + "",
            tipocomp,
            tipocompf + "",
            cliente + "",
            nombre,
            codiva,
            cuit,
            ingbru,
            neto21 + "",
            neto105 + "",
            iva21 + "",
            iva105 + "",
            exento + "",
            total + "",
            vendedor,
            dctoseña + "",
            caja + "",
            ctacte + "",
            itc + "",
            tgo + "",
            impint + "",
            pcaja + "",
            cae,
            fvcae,
            rectarjeta + "",
            dtogral + "",
            fechavto + "",
            notas
        };

        return ventasStringArray;
    }

    public static int getUltimoRegistro() {
        int ultRegistro = 0;

        try {
            AdaptadorJDBC datos = new AdaptadorJDBC("root", Global.passw);

            String consulta = "SELECT MAX(REGISTRO) FROM VENTAS";

            datos.consultar(consulta);

            while (datos.resultados.next()) {
                ultRegistro = datos.resultados.getInt(1);

            }
        } catch (Exception e) {

        }

        return ultRegistro;
    }

    public static String[][] listarVentas(String nombre) {
        String[][] salida;

        try {
            AdaptadorJDBC datos = new AdaptadorJDBC("root", Global.passw);

            if (nombre.charAt(0) == ' ') {
                nombre = nombre.substring(1);
            }

            String consulta = "Select registro, nombre, fecha from ventas where nombre like '%" + nombre + "%' order by nombre";

            System.err.println(consulta);

            datos.consultar(consulta);

            ArrayList<String[]> temp = new ArrayList();

            while (datos.resultados.next()) {
                temp.add(new String[]{datos.resultados.getString(1), datos.resultados.getString(2), datos.resultados.getString(3)});
            }

            datos.cerrar();
//System.out.println(temp);
            salida = new String[temp.size()][];

            for (int i = 0; i < temp.size(); i++) {
                salida[i] = temp.get(i);
                System.out.println(Arrays.asList(salida[i]));
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
            return null;
        }
        return salida;
    }

    public static String[][] listarVentas() {
        String[][] salida;

        try {
            AdaptadorJDBC datos = new AdaptadorJDBC("root", Global.passw);

            String consulta = "Select registro, nombre, fecha from ventas where length(nombre) > 0 order by nombre";

            System.err.println(consulta);

            datos.consultar(consulta);

            ArrayList<String[]> temp = new ArrayList();

            while (datos.resultados.next()) {
                temp.add(new String[]{datos.resultados.getString(1), datos.resultados.getString(2), datos.resultados.getString(3)});
            }

            datos.cerrar();
//System.out.println(temp);
            salida = new String[temp.size()][];

            for (int i = 0; i < temp.size(); i++) {
                salida[i] = temp.get(i);
                System.out.println(Arrays.asList(salida[i]));
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
            return null;
        }
        return salida;
    }

    public static void main(String[] args) throws Exception {

        Ventas[] ventas = leerBD("root", "admin");

        /*for (int i = 0; i < ventas.length; i++) {
            System.out.println(ventas[i]);

        }*/
        System.out.println(listarVentas("muni"));

        // System.out.println(getUltimoRegistro());
    }
}
