/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author xvr
 */
public class Util {

    public static String precioListaProd(int idBase, int[] productos, double[] precios, int[] lista) {
        String salida = "";

        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < lista.length; j++) {
                salida += "INSERT INTO possoft.precios "
                        + " "
                        + "VALUES (" + ((i * lista.length + j) + idBase) + ", " + lista[j] + ", " + productos[i] + ", " + precios[j] + ");\n";

            }
        }

        return salida;
    }

    public static String formato(double mnt) {
        //Get current locale information
        Locale currentLocale = new Locale("es", "AR");

        /* for(Locale l: Locale.getAvailableLocales()){
            System.out.println(l);
        }*/
//Get currency instance from locale; This will have all currency related information
        Currency currentCurrency = Currency.getInstance(currentLocale);

//Currency Formatter specific to locale
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        
        if(mnt == 0){
            return " - ";
        }

        return currencyFormatter.format(mnt);
    }
    
     public static String formato(int mnt) {
        
        if(mnt == 0){
            return " - ";
        }

        return mnt +"";
    }

    public static void main(String[] args) {
        System.out.println(precioListaProd(28, new int[]{10, 11, 12, 13, 14, 15}, new double[]{600, 700, 800}, new int[]{1, 2, 3}));
    }
}
