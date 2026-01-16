/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import util.*;

public class RegistroActual implements java.io.Serializable {

//DECLARACIÓN DE ATRIBUTOS
    int registro = 0;
    int operacion = 0;

//CONSTANTES RELACIONALES
    public static final String REGISTROACTUAL_TABLA = "REGISTRO_ACTUAL";
    public static final String CAMPO_REGISTRO_TABLA = "REGISTRO_ACTUAL";
    public static final String CAMPO_OPERACION_TABLA = "OPERACION";

    public RegistroActual(int registro, int operacion) {
        this.registro = registro;
        this.operacion = operacion;
    }

    public int getRegistro() {
        return registro;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public void setRegistro(String registro) throws Exception {
        this.registro = new Integer(registro).intValue();
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }

    public void setOperacion(String operacion) throws Exception {
        this.operacion = new Integer(operacion).intValue();
    }
// GUARDAR EN LA BASE DE DATOS

    public synchronized void guardarEnBD(String usuario, String clave) throws Exception {
        AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);

        String consulta = "INSERT INTO " + REGISTROACTUAL_TABLA + " VALUES( "
                + registro + ", "
                + operacion + ")";

        datos.actualizar(consulta);
        datos.cerrar();

    }

    public synchronized void guardarEnBD() throws Exception {
        guardarEnBD("root", "admin");
    }

    public RegistroActual actualizarBD(String usuario, String clave) throws Exception {
        AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);
        String consulta = "UPDATE " + REGISTROACTUAL_TABLA + " SET \n";
        consulta += CAMPO_REGISTRO_TABLA + " = '" + getRegistro() + "', \n";
        consulta += CAMPO_OPERACION_TABLA + " = '" + getOperacion() + "' \n";

        consulta += "WHERE " + CAMPO_REGISTRO_TABLA + " = '" + getRegistro() + "';";

        datos.actualizar(consulta);
        return this;
    }

// LEER DE LA BASE DE DATOS
    public static synchronized RegistroActual[] leerBD(String restriccion, String usuario, String clave) {

        RegistroActual registroactuals[];
        java.util.ArrayList<RegistroActual> vectorRegistroActuals = new java.util.ArrayList<>();

        try {
            AdaptadorJDBC datos = new AdaptadorJDBC(usuario, clave);

            String consulta = "SELECT * FROM " + REGISTROACTUAL_TABLA + " WHERE " + restriccion + ";";

            datos.consultar(consulta);

            while (datos.resultados.next()) {
                vectorRegistroActuals.add(new RegistroActual(datos.resultados.getInt(CAMPO_REGISTRO_TABLA),
                        datos.resultados.getInt(CAMPO_OPERACION_TABLA)));
            }

            datos.cerrar();

            registroactuals = new RegistroActual[vectorRegistroActuals.size()];

            for (int i = 0; i < registroactuals.length; i++) {
                registroactuals[i] = ((RegistroActual) vectorRegistroActuals.get(i));
            }

            vectorRegistroActuals.clear();

            return registroactuals;

        } catch (Exception e) {
            System.err.println("Excepción leyendo de la BD: " + e.getMessage());
            return null;
        }
    }

    /**
     * Lee todas las instancias de la clase en la base de datos requiere la
     * validacion
     */
    public static synchronized RegistroActual[] leerBD(String usuario, String clave) throws Exception {
        return leerBD("1=1", usuario, clave);
    }

    public static RegistroActual leerRegistroActualPorID(String idRegistroActual, String usuario, String clave) throws Exception {
        RegistroActual salida = leerBD(CAMPO_REGISTRO_TABLA + " = '" + idRegistroActual + "'", usuario, clave)[0];
        return salida;
    }

    public static RegistroActual[] leerRegistroActualPorRegistro(String registro, String usuario, String clave) throws Exception {
        RegistroActual[] salida = leerBD(CAMPO_REGISTRO_TABLA + " LIKE '%" + registro + "%'", usuario, clave);
        return salida;
    }

    public static RegistroActual[] leerRegistroActualPorOperacion(String operacion, String usuario, String clave) throws Exception {
        RegistroActual[] salida = leerBD(CAMPO_OPERACION_TABLA + " LIKE '%" + operacion + "%'", usuario, clave);
        return salida;
    }

    public static String seleccionarRegistroActual(String regis, String usuario, String clave) {
        String cadena = "<SELECT NAME=\"" + regis + "\">\n";

        cadena += "<OPTION VALUE=\"\"> ---\n";
        RegistroActual[] registroactuals = leerBD("1=1 ORDER BY OPERACION", usuario, clave);

        for (int i = 0; i < registroactuals.length; i++) {
            cadena += "<OPTION VALUE=\"" + registroactuals[i].toStringArray()[0] + "\">"
                    + registroactuals[i].toStringArray()[1] + "\n";
        }
        cadena += "</SELECT>";
        return cadena;
    }

    public static String seleccionarRegistroActual(String regis, RegistroActual[] registroactuals) {
        String cadena = "<SELECT NAME=\"" + regis + "\">\n";

        for (int i = 0; i < registroactuals.length; i++) {
            cadena += "<OPTION VALUE=\"" + registroactuals[i].toStringArray()[0] + "\">"
                    + registroactuals[i].toStringArray()[1] + "\n";
        }
        cadena += "</SELECT>";
        return cadena;
    }

    public String toString() {
        return "\nregistro: " + registro
                + "\noperacion: " + operacion;
    }

    public String[] toStringArray() {

        String[] registroactualStringArray = {
            registro + "",
            operacion + ""
        };

        return registroactualStringArray;
    }

    public static void actualizarRegistro(int registro) {

        AdaptadorJDBC datos = new AdaptadorJDBC("root", "admin");

        String consulta = "UPDATE REGISTRO_ACTUAL SET REGISTRO_ACTUAL = " + registro + "; ";

        try {
            datos.actualizar(consulta);
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public static int getRegistroActual() {
        int out = 0;
        try {
            out = RegistroActual.leerBD("root", "admin")[0].getRegistro();
        } catch (Exception e) {
        }
        return out;
    }

    public static void main(String[] args) throws Exception {

        RegistroActual[] registroactual = leerBD("root", "admin");

        for (int i = 0; i < registroactual.length; i++) {
            System.out.println(registroactual[i]);

        }
    }
}
