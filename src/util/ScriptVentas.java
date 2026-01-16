/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author SistemasR099
 */
public class ScriptVentas {
    
    public static void main(String[] args) throws Exception{
        
        
        BufferedReader br = new BufferedReader(new FileReader(new File("./Ventas_202010.txt")));
        
        String temp = br.readLine();
        
        ArrayList<String> lineas = new ArrayList();
        
        while(temp != null){
            lineas.add(temp);
            //System.out.println(linea);
            temp = br.readLine();
        }
        
        for(String linea: lineas){
            System.out.println(linea.substring(0, 8));  //fecha
            System.out.println(linea.substring(8, 11)); //tipo
            System.out.println(linea.substring(11, 16));    //punto de venta
            System.out.println(linea.substring(16, 36));    //numero desde
            System.out.println(linea.substring(36, 56));    //numero hasta
              System.out.println(linea.substring(56, 58));  //codigo doc comprador
              System.out.println(linea.substring(58, 78));  //numero identificador comprador
              System.out.println(linea.substring(78, 108));  //apellido y nombre comprador
              System.out.println(linea.substring(108, 123));    //importe total
        }
        
        
    }
    
}
