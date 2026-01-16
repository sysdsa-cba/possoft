/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.*;

public class Cliente implements java.io.Serializable {

//DECLARACIÓN DE ATRIBUTOS
    int id = 0;
    int codcli = 0;
    Character sexo = 'O';
    String nombre = "";
    String domicilio = "";
    String te = "";
    String celular = "";
    String tealternativo = "";
    String barrio = "";
    String provincia = "";
    String tipodoc = "";
    String codiva = "";
    String cuit = "";
    String ingbru = "";
    Fecha nacimiento;
    String categoria = "";
    String notas = "";
    String email = "";
    int codsuc = 0;
    String vendedor = "";
    double saldo = 0.0;
    String codpos = "";
    Fecha fechaing = new Fecha(1, 1, 2001);
    Fecha fechacom = new Fecha(1, 1, 2001);
    double descuento = 0.0;
    double lista = 0.0;
    double limcredito = 0.0;
    Fecha fecha = new Fecha(1, 1, 2001);
    String localidad = "";
    String cliente = "";
    Fecha fechapago = new Fecha(1, 1, 2001);
    Fecha fechavto = new Fecha(1, 1, 2001);
    String estadocivil = "";
    int hijos = 0;
    String fichamedia = "";
    String cobertmed = "";
    String ddjjmedica = "";
    String turno1 = "";
    String turno2 = "";
    String turno3 = "";
    String profe = "";
    String actividad1 = "";
    String actividad2 = "";
    String actividad3 = "";
    String foto = "";
    int ingresos = 0;

//CONSTANTES RELACIONALES
    public static final String CLIENTE_TABLA = "CLIENTE";
    public static final String CAMPO_ID_TABLA = "ID";
    public static final String CAMPO_CODCLI_TABLA = "CODCLI";
    public static final String CAMPO_SEXO_TABLA = "SEXO";
    public static final String CAMPO_NOMBRE_TABLA = "NOMBRE";
    public static final String CAMPO_DOMICILIO_TABLA = "DOMICILIO";
    public static final String CAMPO_TE_TABLA = "TE";
    public static final String CAMPO_CELULAR_TABLA = "CELULAR";
    public static final String CAMPO_TEALTERNATIVO_TABLA = "TEALTERNATIVO";
    public static final String CAMPO_BARRIO_TABLA = "BARRIO";
    public static final String CAMPO_PROVINCIA_TABLA = "PROVINCIA";
    public static final String CAMPO_TIPODOC_TABLA = "TIPODOC";
    public static final String CAMPO_CODIVA_TABLA = "CODIVA";
    public static final String CAMPO_CUIT_TABLA = "CUIT";
    public static final String CAMPO_INGBRU_TABLA = "INGBRU";
    public static final String CAMPO_NACIMIENTO_TABLA = "NACIMIENTO";
    public static final String CAMPO_CATEGORIA_TABLA = "CATEGORIA";
    public static final String CAMPO_NOTAS_TABLA = "NOTAS";
    public static final String CAMPO_EMAIL_TABLA = "EMAIL";
    public static final String CAMPO_CODSUC_TABLA = "CODSUC";
    public static final String CAMPO_VENDEDOR_TABLA = "VENDEDOR";
    public static final String CAMPO_SALDO_TABLA = "SALDO";
    public static final String CAMPO_CODPOS_TABLA = "CODPOS";
    public static final String CAMPO_FECHAING_TABLA = "FECHAING";
    public static final String CAMPO_FECHACOM_TABLA = "FECHACOM";
    public static final String CAMPO_DESCUENTO_TABLA = "DESCUENTO";
    public static final String CAMPO_LISTA_TABLA = "LISTA";
    public static final String CAMPO_LIMCREDITO_TABLA = "LIMCREDITO";
    public static final String CAMPO_FECHA_TABLA = "FECHACON";
    public static final String CAMPO_LOCALIDAD_TABLA = "LOCALIDAD";
    public static final String CAMPO_CLIENTE_TABLA = "CLIENTE";
    public static final String CAMPO_FECHAPAGO_TABLA = "FECHA_PAGO";
    public static final String CAMPO_FECHAVTO_TABLA = "FECHA_VTO";
    public static final String CAMPO_ESTADOCIVIL_TABLA = "ESTCIVIL";
    public static final String CAMPO_HIJOS_TABLA = "HIJOS";
    public static final String CAMPO_FICHAMEDIA_TABLA = "FICHAMEDICA";
    public static final String CAMPO_COBERTMED_TABLA = "COBERTMED";
    public static final String CAMPO_DDJJMEDICA_TABLA = "DDJJMEDICA";
    public static final String CAMPO_TURNO1_TABLA = "TURNO1";
    public static final String CAMPO_TURNO2_TABLA = "TURNO2";
    public static final String CAMPO_TURNO3_TABLA = "TURNO3";
    public static final String CAMPO_PROFE_TABLA = "PROFE";
    public static final String CAMPO_ACTIVIDAD1_TABLA = "ACTIVIDAD1";
    public static final String CAMPO_ACTIVIDAD2_TABLA = "ACTIVIDAD2";
    public static final String CAMPO_ACTIVIDAD3_TABLA = "ACTIVIDAD3";
    public static final String CAMPO_FOTO_TABLA = "FOTO";
    public static final String CAMPO_INGRESOS_TABLA = "INGRESOS";

    public Cliente() {
        super();
    }

    public Cliente(int id, int codcli, Character sexo, String nombre, String domicilio, String te, String celular, String tealternativo, String barrio, String provincia, String tipodoc, String codiva, String cuit, String ingbru, Fecha nacimiento, String categoria, String notas, String email, int codsuc, String vendedor, double saldo, String codpos, Fecha fechaing, Fecha fechacom, double descuento, double lista, double limcredito, Fecha fecha, String localidad, String cliente, Fecha fechapago, Fecha fechavto, String estadocivil, int hijos, String fichamedia, String cobertmed, String ddjjmedica, String turno1, String turno2, String turno3, String profe, String actividad1, String actividad2, String actividad3, String foto, int ingresos) {
        this.id = id;
        this.codcli = codcli;
        this.sexo = sexo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.te = te;
        this.celular = celular;
        this.tealternativo = tealternativo;
        this.barrio = barrio;
        this.provincia = provincia;
        this.tipodoc = tipodoc;
        this.codiva = codiva;
        this.cuit = cuit;
        this.ingbru = ingbru;
        this.nacimiento = nacimiento;
        this.categoria = categoria;
        this.notas = notas;
        this.email = email;
        this.codsuc = codsuc;
        this.vendedor = vendedor;
        this.saldo = saldo;
        this.codpos = codpos;
        this.fechaing = fechaing;
        this.fechacom = fechacom;
        this.descuento = descuento;
        this.lista = lista;
        this.limcredito = limcredito;
        this.fecha = fecha;
        this.localidad = localidad;
        this.cliente = cliente;
        this.fechapago = fechapago;
        this.fechavto = fechavto;
        this.estadocivil = estadocivil;
        this.hijos = hijos;
        this.fichamedia = fichamedia;
        this.cobertmed = cobertmed;
        this.ddjjmedica = ddjjmedica;
        this.turno1 = turno1;
        this.turno2 = turno2;
        this.turno3 = turno3;
        this.profe = profe;
        this.actividad1 = actividad1;
        this.actividad2 = actividad2;
        this.actividad3 = actividad3;
        this.foto = foto;
        this.ingresos = ingresos;
    }

    public int getId() {
        return id;
    }

    public int getCodcli() {
        return codcli;
    }

    public Character getSexo() {
        return sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getTe() {
        return te;
    }

    public String getCelular() {
        return celular;
    }

    public String getTealternativo() {
        return tealternativo;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getTipodoc() {
        return tipodoc;
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

    public Fecha getNacimiento() {
        return nacimiento;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNotas() {
        return notas;
    }

    public String getEmail() {
        return email;
    }

    public int getCodsuc() {
        return codsuc;
    }

    public String getVendedor() {
        return vendedor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCodpos() {
        return codpos;
    }

    public Fecha getFechaing() {
        return fechaing;
    }

    public Fecha getFechacom() {
        return fechacom;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getLista() {
        return lista;
    }

    public double getLimcredito() {
        return limcredito;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getCliente() {
        return cliente;
    }

    public Fecha getFechapago() {
        return fechapago;
    }

    public Fecha getFechavto() {
        return fechavto;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public int getHijos() {
        return hijos;
    }

    public String getFichamedia() {
        return fichamedia;
    }

    public String getCobertmed() {
        return cobertmed;
    }

    public String getDdjjmedica() {
        return ddjjmedica;
    }

    public String getTurno1() {
        return turno1;
    }

    public String getTurno2() {
        return turno2;
    }

    public String getTurno3() {
        return turno3;
    }

    public String getProfe() {
        return profe;
    }

    public String getActividad1() {
        return actividad1;
    }

    public String getActividad2() {
        return actividad2;
    }

    public String getActividad3() {
        return actividad3;
    }

    public String getFoto() {
        return foto;
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(String id) throws Exception {
        this.id = Integer.parseInt(id);
    }

    public void setCodcli(int codcli) {
        this.codcli = codcli;
    }

    public void setCodcli(String codcli) throws Exception {
        this.codcli = Integer.parseInt(codcli);
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public void setSexo(String sexo) throws Exception {
        this.sexo =  sexo.charAt(0);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setTe(String te) {
        this.te = te;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setTealternativo(String tealternativo) {
        this.tealternativo = tealternativo;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
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

    public void setNacimiento(Fecha nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setNacimiento(String nacimiento) throws Exception {
        this.nacimiento = new Fecha(nacimiento);
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCodsuc(int codsuc) {
        this.codsuc = codsuc;
    }

    public void setCodsuc(String codsuc) throws Exception {
        this.codsuc = Integer.parseInt(codsuc);
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setSaldo(String saldo) throws Exception {
        this.saldo = Double.parseDouble(saldo);
    }

    public void setCodpos(String codpos) {
        this.codpos = codpos;
    }

    public void setFechaing(Fecha fechaing) {
        this.fechaing = fechaing;
    }

    public void setFechaing(String fechaing) throws Exception {
        this.fechaing = new Fecha(fechaing);
    }

    public void setFechacom(Fecha fechacom) {
        this.fechacom = fechacom;
    }

    public void setFechacom(String fechacom) throws Exception {
        this.fechacom = new Fecha(fechacom);
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setDescuento(String descuento) throws Exception {
        this.descuento = new Double(descuento).doubleValue();
    }

    public void setLista(double lista) {
        this.lista = lista;
    }

    public void setLista(String lista) throws Exception {
        this.lista = new Double(lista).doubleValue();
    }

    public void setLimcredito(double limcredito) {
        this.limcredito = limcredito;
    }

    public void setLimcredito(String limcredito) throws Exception {
        this.limcredito = new Double(limcredito).doubleValue();
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public void setFecha(String fecha) throws Exception {
        this.fecha = new Fecha(fecha);
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setFechapago(Fecha fechapago) {
        this.fechapago = fechapago;
    }

    public void setFechapago(String fechapago) throws Exception {
        this.fechapago = new Fecha(fechapago);
    }

    public void setFechavto(Fecha fechavto) {
        this.fechavto = fechavto;
    }

    public void setFechavto(String fechavto) throws Exception {
        this.fechavto = new Fecha(fechavto);
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    public void setHijos(String hijos) throws Exception {
        this.hijos = new Integer(hijos).intValue();
    }

    public void setFichamedia(String fichamedia) {
        this.fichamedia = fichamedia;
    }

    public void setCobertmed(String cobertmed) {
        this.cobertmed = cobertmed;
    }

    public void setDdjjmedica(String ddjjmedica) {
        this.ddjjmedica = ddjjmedica;
    }

    public void setTurno1(String turno1) {
        this.turno1 = turno1;
    }

    public void setTurno2(String turno2) {
        this.turno2 = turno2;
    }

    public void setTurno3(String turno3) {
        this.turno3 = turno3;
    }

    public void setProfe(String profe) {
        this.profe = profe;
    }

    public void setActividad1(String actividad1) {
        this.actividad1 = actividad1;
    }

    public void setActividad2(String actividad2) {
        this.actividad2 = actividad2;
    }

    public void setActividad3(String actividad3) {
        this.actividad3 = actividad3;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    public void setIngresos(String ingresos) throws Exception {
        this.ingresos = new Integer(ingresos).intValue();
    }
// GUARDAR EN LA BASE DE DATOS

    public synchronized void guardarEnBD(String usuario, String clave) throws Exception {
        AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);

        String consulta = "INSERT INTO " + CLIENTE_TABLA + " VALUES( "
                + id + ", "
                + codcli + ", '"
                + sexo + "', '"
                + nombre + "', '"
                + domicilio + "', '"
                + te + "', '"
                + celular + "', '"
                + tealternativo + "', '"
                + barrio + "', '"
                + provincia + "', '"
                + tipodoc + "', '"
                + codiva + "', '"
                + cuit + "', '"
                + ingbru + "', '"
                + "2001-01-01', '"
                + categoria + "', '"
                + notas + "', '"
                + email + "', "
                + codsuc + ", '"
                + vendedor + "', "
                + saldo + ", '"
                + codpos + "', "
                /*+ fechaing + "', '"
                + fechacom + "', "*/
                + descuento + ", "
                + lista + ", "
                + limcredito + ", '"
                + fecha.getFechaMySQL() + "', '"
                + localidad + "', '"
                + cliente + "', '"
                + fechapago.getFechaMySQL() + "', '"
                + fechavto.getFechaMySQL() + "', '"
                + estadocivil + "', "
                + hijos + ", '"
                + fichamedia + "', '"
                + cobertmed + "', '"
                + ddjjmedica + "', '"
                + turno1 + "', '"
                + turno2 + "', '"
                + turno3 + "', '"
                + actividad1 + "', '"
                + actividad2 + "', '"
                + actividad3 + "', '"
                + fechacom.getFechaMySQL() + "', '"
                + foto + "', "
                + ingresos + ", '"
                + profe + "', '"
                + fechaing.getFechaMySQL()
                + "')";

        System.err.println(consulta);

        datos.actualizar(consulta);
        datos.cerrar();

    }

    public synchronized void guardarEnBD() throws Exception {
        guardarEnBD("root", Global.passw);
    }

    public Cliente actualizarBD(String usuario, String clave) throws Exception {
        AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);
        String consulta = "UPDATE " + CLIENTE_TABLA + " SET \n";
        consulta += CAMPO_ID_TABLA + " = '" + getId() + "', \n";
        consulta += CAMPO_CODCLI_TABLA + " = '" + getCodcli() + "', \n";
        consulta += CAMPO_SEXO_TABLA + " = '" + getSexo() + "', \n";
        consulta += CAMPO_NOMBRE_TABLA + " = '" + getNombre() + "', \n";
        consulta += CAMPO_DOMICILIO_TABLA + " = '" + getDomicilio() + "', \n";
        consulta += CAMPO_TE_TABLA + " = '" + getTe() + "', \n";
        consulta += CAMPO_CELULAR_TABLA + " = '" + getCelular() + "', \n";
        consulta += CAMPO_TEALTERNATIVO_TABLA + " = '" + getTealternativo() + "', \n";
        consulta += CAMPO_BARRIO_TABLA + " = '" + getBarrio() + "', \n";
        consulta += CAMPO_PROVINCIA_TABLA + " = '" + getProvincia() + "', \n";
        consulta += CAMPO_TIPODOC_TABLA + " = '" + getTipodoc() + "', \n";
        consulta += CAMPO_CODIVA_TABLA + " = '" + getCodiva() + "', \n";
        consulta += CAMPO_CUIT_TABLA + " = '" + getCuit() + "', \n";
        consulta += CAMPO_INGBRU_TABLA + " = '" + getIngbru() + "', \n";
        consulta += CAMPO_NACIMIENTO_TABLA + " = '" + getNacimiento() + "', \n";
        consulta += CAMPO_CATEGORIA_TABLA + " = '" + getCategoria() + "', \n";
        consulta += CAMPO_NOTAS_TABLA + " = '" + getNotas() + "', \n";
        consulta += CAMPO_EMAIL_TABLA + " = '" + getEmail() + "', \n";
        consulta += CAMPO_CODSUC_TABLA + " = '" + getCodsuc() + "', \n";
        consulta += CAMPO_VENDEDOR_TABLA + " = '" + getVendedor() + "', \n";
        consulta += CAMPO_SALDO_TABLA + " = '" + getSaldo() + "', \n";
        consulta += CAMPO_CODPOS_TABLA + " = '" + getCodpos() + "', \n";
        consulta += CAMPO_FECHAING_TABLA + " = '" + getFechaing() + "', \n";
        consulta += CAMPO_FECHACOM_TABLA + " = '" + getFechacom() + "', \n";
        consulta += CAMPO_DESCUENTO_TABLA + " = '" + getDescuento() + "', \n";
        consulta += CAMPO_LISTA_TABLA + " = '" + getLista() + "', \n";
        consulta += CAMPO_LIMCREDITO_TABLA + " = '" + getLimcredito() + "', \n";
        consulta += CAMPO_FECHA_TABLA + " = '" + getFecha() + "', \n";
        consulta += CAMPO_LOCALIDAD_TABLA + " = '" + getLocalidad() + "', \n";
        consulta += CAMPO_CLIENTE_TABLA + " = '" + getCliente() + "', \n";
        consulta += CAMPO_FECHAPAGO_TABLA + " = '" + getFechapago() + "', \n";
        consulta += CAMPO_FECHAVTO_TABLA + " = '" + getFechavto() + "', \n";
        consulta += CAMPO_ESTADOCIVIL_TABLA + " = '" + getEstadocivil() + "', \n";
        consulta += CAMPO_HIJOS_TABLA + " = '" + getHijos() + "', \n";
        consulta += CAMPO_FICHAMEDIA_TABLA + " = '" + getFichamedia() + "', \n";
        consulta += CAMPO_COBERTMED_TABLA + " = '" + getCobertmed() + "', \n";
        consulta += CAMPO_DDJJMEDICA_TABLA + " = '" + getDdjjmedica() + "', \n";
        consulta += CAMPO_TURNO1_TABLA + " = '" + getTurno1() + "', \n";
        consulta += CAMPO_TURNO2_TABLA + " = '" + getTurno2() + "', \n";
        consulta += CAMPO_TURNO3_TABLA + " = '" + getTurno3() + "', \n";
        consulta += CAMPO_PROFE_TABLA + " = '" + getProfe() + "', \n";
        consulta += CAMPO_ACTIVIDAD1_TABLA + " = '" + getActividad1() + "', \n";
        consulta += CAMPO_ACTIVIDAD2_TABLA + " = '" + getActividad2() + "', \n";
        consulta += CAMPO_ACTIVIDAD3_TABLA + " = '" + getActividad3() + "', \n";
        consulta += CAMPO_FOTO_TABLA + " = '" + getFoto() + "', \n";
        consulta += CAMPO_INGRESOS_TABLA + " = '" + getIngresos() + "' \n";

        consulta += "WHERE " + CAMPO_ID_TABLA + " = '" + getId() + "';";

        datos.actualizar(consulta);
        return this;
    }

// LEER DE LA BASE DE DATOS
    public static synchronized Cliente[] leerBD(String restriccion, String usuario, String clave) {

        Cliente clientes[];
        java.util.ArrayList<Cliente> vectorClientes = new java.util.ArrayList<>();

        try {
            AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);

            String consulta = "SELECT * FROM " + CLIENTE_TABLA + " WHERE " + restriccion + ";";

            datos.consultar(consulta);

            while (datos.resultados.next()) {
                vectorClientes.add(new Cliente(datos.resultados.getInt(CAMPO_ID_TABLA),
                        datos.resultados.getInt(CAMPO_CODCLI_TABLA),
                        datos.resultados.getString(CAMPO_SEXO_TABLA).charAt(0),
                        datos.resultados.getString(CAMPO_NOMBRE_TABLA),
                        datos.resultados.getString(CAMPO_DOMICILIO_TABLA),
                        datos.resultados.getString(CAMPO_TE_TABLA),
                        datos.resultados.getString(CAMPO_CELULAR_TABLA),
                        datos.resultados.getString(CAMPO_TEALTERNATIVO_TABLA),
                        datos.resultados.getString(CAMPO_BARRIO_TABLA),
                        datos.resultados.getString(CAMPO_PROVINCIA_TABLA),
                        datos.resultados.getString(CAMPO_TIPODOC_TABLA),
                        datos.resultados.getString(CAMPO_CODIVA_TABLA),
                        datos.resultados.getString(CAMPO_CUIT_TABLA),
                        datos.resultados.getString(CAMPO_INGBRU_TABLA),
                        new Fecha().setFechaMySQL(datos.resultados.getString(CAMPO_NACIMIENTO_TABLA)),
                        datos.resultados.getString(CAMPO_CATEGORIA_TABLA),
                        datos.resultados.getString(CAMPO_NOTAS_TABLA),
                        datos.resultados.getString(CAMPO_EMAIL_TABLA),
                        datos.resultados.getInt(CAMPO_CODSUC_TABLA),
                        datos.resultados.getString(CAMPO_VENDEDOR_TABLA),
                        datos.resultados.getDouble(CAMPO_SALDO_TABLA),
                        datos.resultados.getString(CAMPO_CODPOS_TABLA),
                        new Fecha().setFechaMySQL(datos.resultados.getString(CAMPO_FECHAING_TABLA)),
                        new Fecha().setFechaMySQL(datos.resultados.getString(CAMPO_FECHACOM_TABLA)),
                        datos.resultados.getDouble(CAMPO_DESCUENTO_TABLA),
                        datos.resultados.getDouble(CAMPO_LISTA_TABLA),
                        datos.resultados.getDouble(CAMPO_LIMCREDITO_TABLA),
                        new Fecha().setFechaMySQL(datos.resultados.getString(CAMPO_FECHA_TABLA)),
                        datos.resultados.getString(CAMPO_LOCALIDAD_TABLA),
                        datos.resultados.getString(CAMPO_CLIENTE_TABLA),
                        new Fecha().setFechaMySQL(datos.resultados.getString(CAMPO_FECHAPAGO_TABLA)),
                        new Fecha().setFechaMySQL(datos.resultados.getString(CAMPO_FECHAVTO_TABLA)),
                        datos.resultados.getString(CAMPO_ESTADOCIVIL_TABLA),
                        datos.resultados.getInt(CAMPO_HIJOS_TABLA),
                        datos.resultados.getString(CAMPO_FICHAMEDIA_TABLA),
                        datos.resultados.getString(CAMPO_COBERTMED_TABLA),
                        datos.resultados.getString(CAMPO_DDJJMEDICA_TABLA),
                        datos.resultados.getString(CAMPO_TURNO1_TABLA),
                        datos.resultados.getString(CAMPO_TURNO2_TABLA),
                        datos.resultados.getString(CAMPO_TURNO3_TABLA),
                        datos.resultados.getString(CAMPO_PROFE_TABLA),
                        datos.resultados.getString(CAMPO_ACTIVIDAD1_TABLA),
                        datos.resultados.getString(CAMPO_ACTIVIDAD2_TABLA),
                        datos.resultados.getString(CAMPO_ACTIVIDAD3_TABLA),
                        datos.resultados.getString(CAMPO_FOTO_TABLA),
                        datos.resultados.getInt(CAMPO_INGRESOS_TABLA)));
            }

            datos.cerrar();

            clientes = new Cliente[vectorClientes.size()];

            for (int i = 0; i < clientes.length; i++) {
                clientes[i] = ((Cliente) vectorClientes.get(i));
            }

            vectorClientes.clear();

            return clientes;

        } catch (Exception e) {
            System.err.println("Excepción leyendo de la BD: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Lee todas las instancias de la clase en la base de datos requiere la
     * validacion
     */
    public static synchronized Cliente[] leerBD(String usuario, String clave) throws Exception {
        return leerBD("1=1", usuario, clave);
    }

    /*  public static Cliente leerClientePorID(String idCliente, String usuario, String clave) throws Exception {
        Cliente salida = leerBD(CAMPO_CLIENTE_TABLA + " = '" + idCliente + "'", usuario, clave)[0];
        return salida;
    }*/
    public static Cliente[] leerClientePorId(String id, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_ID_TABLA + " LIKE '%" + id + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorCodcli(String codcli, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_CODCLI_TABLA + " LIKE '%" + codcli + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorSexo(String sexo, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_SEXO_TABLA + " LIKE '%" + sexo + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorNombre(String nombre, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_NOMBRE_TABLA + " LIKE '%" + nombre + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorDomicilio(String domicilio, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_DOMICILIO_TABLA + " LIKE '%" + domicilio + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorTe(String te, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_TE_TABLA + " LIKE '%" + te + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorCelular(String celular, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_CELULAR_TABLA + " LIKE '%" + celular + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorTealternativo(String tealternativo, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_TEALTERNATIVO_TABLA + " LIKE '%" + tealternativo + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorBarrio(String barrio, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_BARRIO_TABLA + " LIKE '%" + barrio + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorProvincia(String provincia, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_PROVINCIA_TABLA + " LIKE '%" + provincia + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorTipodoc(String tipodoc, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_TIPODOC_TABLA + " LIKE '%" + tipodoc + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorCodiva(String codiva, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_CODIVA_TABLA + " LIKE '%" + codiva + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorCuit(String cuit, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_CUIT_TABLA + " LIKE '%" + cuit + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorIngbru(String ingbru, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_INGBRU_TABLA + " LIKE '%" + ingbru + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorNacimiento(String nacimiento, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_NACIMIENTO_TABLA + " LIKE '%" + nacimiento + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorCategoria(String categoria, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_CATEGORIA_TABLA + " LIKE '%" + categoria + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorNotas(String notas, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_NOTAS_TABLA + " LIKE '%" + notas + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorEmail(String email, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_EMAIL_TABLA + " LIKE '%" + email + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorCodsuc(String codsuc, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_CODSUC_TABLA + " LIKE '%" + codsuc + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorVendedor(String vendedor, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_VENDEDOR_TABLA + " LIKE '%" + vendedor + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorSaldo(String saldo, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_SALDO_TABLA + " LIKE '%" + saldo + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorCodpos(String codpos, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_CODPOS_TABLA + " LIKE '%" + codpos + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorFechaing(String fechaing, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_FECHAING_TABLA + " LIKE '%" + fechaing + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorFechacom(String fechacom, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_FECHACOM_TABLA + " LIKE '%" + fechacom + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorDescuento(String descuento, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_DESCUENTO_TABLA + " LIKE '%" + descuento + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorLista(String lista, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_LISTA_TABLA + " LIKE '%" + lista + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorLimcredito(String limcredito, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_LIMCREDITO_TABLA + " LIKE '%" + limcredito + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorFecha(String fecha, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_FECHA_TABLA + " LIKE '%" + fecha + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorLocalidad(String localidad, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_LOCALIDAD_TABLA + " LIKE '%" + localidad + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorCliente(String cliente, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_CLIENTE_TABLA + " LIKE '%" + cliente + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorFechapago(String fechapago, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_FECHAPAGO_TABLA + " LIKE '%" + fechapago + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorFechavto(String fechavto, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_FECHAVTO_TABLA + " LIKE '%" + fechavto + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorEstadocivil(String estadocivil, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_ESTADOCIVIL_TABLA + " LIKE '%" + estadocivil + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorHijos(String hijos, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_HIJOS_TABLA + " LIKE '%" + hijos + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorFichamedia(String fichamedia, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_FICHAMEDIA_TABLA + " LIKE '%" + fichamedia + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorCobertmed(String cobertmed, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_COBERTMED_TABLA + " LIKE '%" + cobertmed + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorDdjjmedica(String ddjjmedica, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_DDJJMEDICA_TABLA + " LIKE '%" + ddjjmedica + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorTurno1(String turno1, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_TURNO1_TABLA + " LIKE '%" + turno1 + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorTurno2(String turno2, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_TURNO2_TABLA + " LIKE '%" + turno2 + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorTurno3(String turno3, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_TURNO3_TABLA + " LIKE '%" + turno3 + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorProfe(String profe, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_PROFE_TABLA + " LIKE '%" + profe + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorActividad1(String actividad1, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_ACTIVIDAD1_TABLA + " LIKE '%" + actividad1 + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorActividad2(String actividad2, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_ACTIVIDAD2_TABLA + " LIKE '%" + actividad2 + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorActividad3(String actividad3, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_ACTIVIDAD3_TABLA + " LIKE '%" + actividad3 + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorFoto(String foto, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_FOTO_TABLA + " LIKE '%" + foto + "%'", usuario, clave);
        return salida;
    }

    public static Cliente[] leerClientePorIngresos(String ingresos, String usuario, String clave) throws Exception {
        Cliente[] salida = leerBD(CAMPO_INGRESOS_TABLA + " LIKE '%" + ingresos + "%'", usuario, clave);
        return salida;
    }

    public static String seleccionarCliente(String clies, String usuario, String clave) {
        String cadena = "<SELECT NAME=\"" + clies + "\">\n";

        cadena += "<OPTION VALUE=\"\"> ---\n";
        Cliente[] clientes = leerBD("1=1 ORDER BY CODCLI", usuario, clave);

        for (int i = 0; i < clientes.length; i++) {
            cadena += "<OPTION VALUE=\"" + clientes[i].toStringArray()[0] + "\">"
                    + clientes[i].toStringArray()[1] + "\n";
        }
        cadena += "</SELECT>";
        return cadena;
    }

    public static String seleccionarCliente(String clies, Cliente[] clientes) {
        String cadena = "<SELECT NAME=\"" + clies + "\">\n";

        for (int i = 0; i < clientes.length; i++) {
            cadena += "<OPTION VALUE=\"" + clientes[i].toStringArray()[0] + "\">"
                    + clientes[i].toStringArray()[1] + "\n";
        }
        cadena += "</SELECT>";
        return cadena;
    }

    public String toString() {
        return "\nid: " + id
                + "\ncodcli: " + codcli
                + "\nsexo: " + sexo
                + "\nnombre: " + nombre
                + "\ndomicilio: " + domicilio
                + "\nte: " + te
                + "\ncelular: " + celular
                + "\ntealternativo: " + tealternativo
                + "\nbarrio: " + barrio
                + "\nprovincia: " + provincia
                + "\ntipodoc: " + tipodoc
                + "\ncodiva: " + codiva
                + "\ncuit: " + cuit
                + "\ningbru: " + ingbru
                + "\nnacimiento: " + nacimiento
                + "\ncategoria: " + categoria
                + "\nnotas: " + notas
                + "\nemail: " + email
                + "\ncodsuc: " + codsuc
                + "\nvendedor: " + vendedor
                + "\nsaldo: " + saldo
                + "\ncodpos: " + codpos
                + "\nfechaing: " + fechaing
                + "\nfechacom: " + fechacom
                + "\ndescuento: " + descuento
                + "\nlista: " + lista
                + "\nlimcredito: " + limcredito
                + "\nfecha: " + fecha
                + "\nlocalidad: " + localidad
                + "\ncliente: " + cliente
                + "\nfechapago: " + fechapago
                + "\nfechavto: " + fechavto
                + "\nestadocivil: " + estadocivil
                + "\nhijos: " + hijos
                + "\nfichamedia: " + fichamedia
                + "\ncobertmed: " + cobertmed
                + "\nddjjmedica: " + ddjjmedica
                + "\nturno1: " + turno1
                + "\nturno2: " + turno2
                + "\nturno3: " + turno3
                + "\nprofe: " + profe
                + "\nactividad1: " + actividad1
                + "\nactividad2: " + actividad2
                + "\nactividad3: " + actividad3
                + "\nfoto: " + foto
                + "\ningresos: " + ingresos;
    }

    public String[] toStringArray() {

        String[] clienteStringArray = {
            id + "",
            codcli + "",
            sexo + "",
            nombre,
            domicilio,
            te,
            celular,
            tealternativo,
            barrio,
            provincia,
            tipodoc,
            codiva,
            cuit,
            ingbru,
            nacimiento + "",
            categoria,
            notas,
            email,
            codsuc + "",
            vendedor,
            saldo + "",
            codpos,
            fechaing + "",
            fechacom + "",
            descuento + "",
            lista + "",
            limcredito + "",
            fecha + "",
            localidad,
            cliente,
            fechapago + "",
            fechavto + "",
            estadocivil,
            hijos + "",
            fichamedia,
            cobertmed,
            ddjjmedica,
            turno1,
            turno2,
            turno3,
            profe,
            actividad1,
            actividad2,
            actividad3,
            foto,
            ingresos + ""
        };

        return clienteStringArray;
    }

    public static String[][] listarClientes() {
        String[][] salida;

        try {
            AdaptadorJDBC datos = new AdaptadorJDBC("root", Global.passw);

            String consulta = "Select nombre, id from cliente order by nombre";

            datos.consultar(consulta);

            ArrayList<String[]> temp = new ArrayList();

            while (datos.resultados.next()) {
                temp.add(new String[]{datos.resultados.getString(1), datos.resultados.getString(2)});
            }

            datos.cerrar();
//System.out.println(temp);
            salida = new String[temp.size()][];

            for (int i = 0; i < temp.size(); i++) {
                salida[i] = temp.get(i);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
            return null;
        }
        return salida;
    }

    public static String[][] listarClientes(String nombre) {
        String[][] salida;

        try {
            AdaptadorJDBC datos = new AdaptadorJDBC("root", Global.passw);

            if (nombre.charAt(0) == ' ') {
                nombre = nombre.substring(1);
            }

            String consulta = "Select nombre, id from cliente where nombre like '%" + nombre + "%' order by nombre";

            System.err.println(consulta);

            datos.consultar(consulta);

            ArrayList<String[]> temp = new ArrayList();

            while (datos.resultados.next()) {
                temp.add(new String[]{datos.resultados.getString(1), datos.resultados.getString(2)});
            }

            datos.cerrar();
//System.out.println(temp);
            salida = new String[temp.size()][];

            for (int i = 0; i < temp.size(); i++) {
                salida[i] = temp.get(i);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
            return null;
        }
        return salida;
    }

    public static String[][] listarClientesVentas() {
        String[][] salida;

        try {
            AdaptadorJDBC datos = new AdaptadorJDBC("root", Global.passw);

            String consulta = "select c.codcli , c.nombre , c.cuit , c.te, c.saldo \n"
                    + "from cliente c\n"
                    + "order by nombre";

            datos.consultar(consulta);

            ArrayList<String[]> temp = new ArrayList();

            while (datos.resultados.next()) {
                temp.add(new String[]{datos.resultados.getString(1), datos.resultados.getString(2),
                    datos.resultados.getString(3),
                    datos.resultados.getString(4),
                    datos.resultados.getString(5)
                });
            }

            datos.cerrar();
//System.out.println(temp);
            salida = new String[temp.size()][];

            for (int i = 0; i < temp.size(); i++) {
                salida[i] = temp.get(i);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
            return null;
        }
        return salida;
    }

    public static String[][] listarClientesVentas(String nombre) {
        String[][] salida;

        try {
            AdaptadorJDBC datos = new AdaptadorJDBC("root", Global.passw);

            String consulta = "select c.codcli , c.nombre , c.cuit , c.te, c.saldo \n"
                    + "from cliente c\n "
                    + "where nombre like '%" + nombre + "%' "
                    + "order by nombre";

            datos.consultar(consulta);

            ArrayList<String[]> temp = new ArrayList();

            while (datos.resultados.next()) {
                temp.add(new String[]{datos.resultados.getString(1), datos.resultados.getString(2),
                    datos.resultados.getString(3),
                    datos.resultados.getString(4),
                    datos.resultados.getString(5)
                });
            }

            datos.cerrar();
//System.out.println(temp);
            salida = new String[temp.size()][];

            for (int i = 0; i < temp.size(); i++) {
                salida[i] = temp.get(i);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
            return null;
        }
        return salida;
    }

    public static Pares clientes() {
        Pares pares = new Pares();

        try {
            Cliente[] cli = leerBD("root", Global.passw);

            for (Cliente clien : cli) {
                pares.codigos.add(clien.getCodcli());
                pares.nombres.add(clien.getNombre().toLowerCase());
            }

        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pares;
    }

    public static synchronized ArrayList<String> nombres() {
        return clientes().getNombres();
    }

    public static void main(String[] args) throws Exception {

        Cliente[] cliente = leerBD("root", Global.passw);

        //  System.out.println(cliente.length);
        for (int i = 0; i < cliente.length; i++) {
            //System.out.println(cliente[i]);

        }

//        System.out.print(Arrays.asList(listarClientes()[0]));
        // Cliente cl = Cliente.leerClientePorId(1775 + "", "root", Global.passw)[0];
        System.out.println(getNuevoId());

        System.out.println(clientes());

    }

    public static int getNuevoId() {
        int nuevoId = 999999;

        AdaptadorJDBC datos = new AdaptadorJDBC("root", Global.passw);

        datos.consultar("select max(codcli) from cliente");

        try {
            while (datos.resultados.next()) {
                nuevoId = datos.resultados.getInt(1) + 1;
            }
        } catch (SQLException ex) {
//            Logger.getLogger(Articulo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nuevoId;
    }
}

class Pares {

    ArrayList<Integer> codigos = new ArrayList<>();
    ArrayList<String> nombres = new ArrayList<>();

    public ArrayList<Integer> getCodigos() {
        return codigos;
    }

    public void setNombres(ArrayList<String> nombres) {
        this.nombres = nombres;
    }

    public ArrayList<String> getNombres() {
        return nombres;
    }

    public Pares() {
    }

    @Override
    public String toString() {
        String salida = "";

        for (int i = 0; i < codigos.size(); i++) {
            salida += codigos.get(i) + ": " + nombres.get(i) + "\n";
        }

        return salida; //To change body of generated methods, choose Tools | Templates.
    }

}
