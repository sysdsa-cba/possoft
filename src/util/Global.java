/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Optional;
import org.ini4j.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Global {

    public static String passw = "admin";

    /* static{
        try{
            passw = System.getenv("gestion_passw").toString();
        }catch(Exception e){
            passw = "";
        }
        if(passw.equals("null"))
            passw = "admin";
    }*/

    public static String getPuntoVenta() {
        String puntoVenta = "0";
        try {

            Wini ini = new Wini(new File("conf/conf.ini"));
            puntoVenta = ini.get("negocio", "punto_venta", String.class);

        } catch (IOException ex) {
            Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
        }
        return puntoVenta;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(passw);

        System.out.println(new File("conf/conf.ini").getCanonicalPath());

        System.out.println(getPuntoVenta());
    }
}
