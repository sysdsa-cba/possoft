/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


/*
 * @(#)JDBCAdapter.java	1.10 99/04/23
 * Copyright (c) 1997-1999 by Sun Microsystems, Inc. All Rights Reserved.
 * An adaptor, transforming the JDBC interface to the TableModel interface.
 * @version 1.20 09/25/97
 * @author Philip Milne
 * Versi�n simplificada para utilizacion en ejercicios
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class AdaptadorJDBC {

    static String DRIVER_MYSQL = "com.mysql.jdbc.Driver";

    //static String DRIVER_ACCESS = "net.ucanaccess.jdbc.UcanloadDriver";
    static String URL_MYSQL = "jdbc:mysql://localhost:3306/possoft_prueba";

    static String USER_ACCESS = "root";
    static String PASS_ACCESS = "admin";

    static String USER_MYSQL = "root";
    static String PASS_MYSQL = "";

    private Connection conexion;
    private Statement declaracion;
    public int Debug = 0;
    public ResultSet resultados;
    public boolean encontrado;

    public AdaptadorJDBC() {
        this(URL_MYSQL, DRIVER_MYSQL, USER_MYSQL, PASS_MYSQL);
    }

    public AdaptadorJDBC(String base) {
        this("jdbc:mysql://localhost:3306/" + base, DRIVER_MYSQL, USER_MYSQL, PASS_MYSQL);
    }

    public AdaptadorJDBC(String usuario, String password) {
        this(URL_MYSQL, DRIVER_MYSQL, usuario, password);
    }

    /* public AdaptadorJDBC(int baseDatos){
     this(URL_BD_SEGURIDAD_ACCESS, ODBC_DRIVER, USER_BD_SEGURIDAD_ACCESS, PASSWORD_BD_SEGURIDAD_ACCESS);
     }*/
    public AdaptadorJDBC(String url, String driverName, String user, String passwd) {
        try {
            Class.forName(driverName);
            if (Debug != 0) {
                System.out.println("Abriendo la conexi�n a la BD");
            }
            conexion = DriverManager.getConnection(url, user, passwd);
            declaracion = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        } catch (ClassNotFoundException ex) {
            System.err.println("No se pueden encontrar las clases de los driver de la Base de Datos.");
            System.err.println(ex);
        } catch (SQLException ex) {
            System.err.println("No se puede conectar a la Base de Datos.");
            System.err.println(ex);
        }
    }

    public ResultSet consultar(String consulta) {
        //   System.err.println(consulta);
        if (conexion == null || declaracion == null) {
            System.err.println("No existe la Base de Datos en donde consultar.");
            return null;
        }
        try {
            if (Debug != 0) {
                System.out.println("SEL:" + consulta);
            }
            resultados = declaracion.executeQuery(consulta);
            if (resultados.next()) {
                encontrado = true;
            }
            resultados.beforeFirst();
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
        return resultados;
    }

    public int actualizar(String psql) throws SQLException {
        if (conexion == null || declaracion == null) {
            System.err.println("No hay base de datos en donde ejecutar la actualizaci�n");
            return 0;
        }
        try {
            if (Debug != 0) {
                System.out.println("SQL:" + psql);
            }

        } catch (Exception ex) {
            //  ex.printStackTrace();
        }

        int count = declaracion.executeUpdate(psql);

        return count;

    }

    public void cerrar() throws SQLException {
        if (Debug != 0) {
            System.out.println("Cerrando la conexi�n a la BD");
        }
        if (!(resultados == null)) {
            resultados.close();
        }
        declaracion.close();
        conexion.close();
    }

    protected void finalizar() throws Throwable {
        cerrar();
        super.finalize();
    }

    public static void main(String[] args) throws Exception {
        AdaptadorJDBC ad = new AdaptadorJDBC("root", "admin");

        String consulta = "select * from producto";

        int i = 1;

        try {
            // ad.actualizar("ALTER TABLE gestion.ventas modify column cuit varchar(11) null");

            // ad.actualizar("update cliente set cuit = '0' where id= 1");
            ad.consultar(consulta);

            while (ad.resultados.next()) {
                for (int j = 0; j < 15; j++) {
                    System.out.print(ad.resultados.getString(j + 1) + " - ");

                }
                System.out.println("");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
