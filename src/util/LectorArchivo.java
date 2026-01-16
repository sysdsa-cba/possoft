/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Logistica
 */
public class LectorArchivo {

    public static void main(String[] args) throws Exception {
        String linea = "";
        String linea_alicuotas = "";

        Scanner lector = new Scanner(new File("C:\\Users\\Logistica\\Desktop\\abril.txt"));
        Scanner lector_alicuotas = new Scanner(new File("C:\\Users\\Logistica\\Desktop\\abril_alicuotas.txt"));

        while (lector.hasNextLine()) {
            linea = lector.nextLine();
            linea_alicuotas = lector_alicuotas.nextLine();

            ArrayList<String> linea_exportada = exportar(linea, linea_alicuotas);
            System.out.println(linea_exportada);
        }

    }

    public static ArrayList<ArrayList<String>> leerYExportar(String rutaArchivo, String rutaAlicuota)
            throws Exception {
        ArrayList<ArrayList<String>> lineas_archivo = new ArrayList();

        String linea = "";
        String linea_alicuotas = "";

        Scanner lector = new Scanner(new File(rutaArchivo));
        Scanner lector_alicuotas = new Scanner(new File(rutaAlicuota));

        while (lector.hasNextLine()) {
            linea = lector.nextLine();
            linea_alicuotas = lector_alicuotas.nextLine();

            ArrayList<String> linea_exportada = exportar(linea, linea_alicuotas);
            lineas_archivo.add(linea_exportada);
        }

        return lineas_archivo;
    }

    public static ArrayList<String> exportar(String linea, String linea_alicuotas) {
        ArrayList<String> salida = new ArrayList();

        String anio = linea.substring(0, 4);
        String mes = linea.substring(4, 6);
        String dia = linea.substring(6, 8);

        String fecha = dia + "/" + mes + "/" + anio;

        String importe_total = linea.substring(108, 123);
        double importe_total_nro = new Double(importe_total) / 100;
        String iva_liquidado = linea_alicuotas.substring(47, 62);
        double iva_liquidado_nro = new Double(iva_liquidado) / 100;

        salida.add(fecha);
        String tipo_comprobante = linea.substring(8, 11);
        salida.add(tipo_comprobante);
        String punto_venta = linea.substring(11, 16);
        salida.add(punto_venta);
        String numero_desde = linea.substring(24, 36);
        salida.add(numero_desde);
        String numero_hasta = linea.substring(44, 56);
        salida.add(numero_hasta);
        String cod_doc_comprador = linea.substring(56, 58);
        salida.add(cod_doc_comprador);
        String nro_identificacion = linea.substring(67, 78);
        salida.add(nro_identificacion);
        
        String apellido_nombre_comprador = linea.substring(78, 108);
        salida.add(apellido_nombre_comprador.trim());
        
        salida.add((importe_total_nro - iva_liquidado_nro) + "");
        
        String conceptos_no = linea.substring(123, 138);
        salida.add(new Double(conceptos_no).toString());
        
        String exentas = linea.substring(153, 168);
        double exentas_nro = new Double(exentas) / 100;

        salida.add(iva_liquidado_nro + "");
                salida.add(exentas_nro + "");
        String ing_brutos = linea.substring(183, 198);
        double ing_brutos_nro = new Double(ing_brutos) / 100;
        salida.add(ing_brutos_nro + "");
        String imp_municipales = linea.substring(198, 213);
        double imp_municipales_nro = new Double(imp_municipales) / 100;
        salida.add(imp_municipales_nro + "");
        salida.add(importe_total_nro + "");

        /* System.out.print(dia + "/" + mes + "/" + anio + "\t");
        System.out.print(tipo_comprobante + "\t");
        System.out.print(punto_venta + "\t");
        System.out.print(numero_desde + "\t");
        System.out.print(numero_hasta + "\t");
        System.out.print(cod_doc_comprador + "\t");
        System.out.print(nro_identificacion + "\t");
        System.out.print(apellido_nombre_comprador + "\t");
        System.out.print(new Double(importe_total) / 100 - new Double(iva_liquidado) / 100 + "\t");
        System.out.print(iva_liquidado_nro + "\t");
        System.out.print(exentas_nro + "\t");
        System.out.print(ing_brutos_nro + "\t");
        System.out.print(imp_municipales_nro + "\t");
        System.out.print(importe_total_nro + "\t");*/
        //  System.out.println("\n");
        return salida;
    }
}
