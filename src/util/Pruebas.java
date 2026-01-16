/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;

/**
 *
 * @author SistemasR099
 */
public class Pruebas {

    public static void main(String[] args) throws Exception{
        try {
          /*  Process p = Runtime.getRuntime().exec("\"/Program Files (x86)/Google/Chrome/Application/chrome.exe\" https:\\javierbengolea.com");
            p.waitFor();
            System.out.println("Google Chrome launched!");*/
          
            System.out.println(new File("PRESUPUESTOS").getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
