/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.*;
import java.net.URL;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author xvr
 */
public class LeerJson {

    public static void main(String[] args) throws Exception {
        
        String ean_code = "7791600037345";

        String url = "https://javierbengolea.com/qr.php?qr=" + ean_code;

        //System.out.println(stream(new URL(url)));
        JSONObject obSon = getJson(new URL(url));
        System.out.println(obSon.keySet());
        System.out.println(obSon.keys());
        System.out.println(getJson(new URL(url)).get("descripcion"));

    }

    public static String stream(URL url) throws Exception {
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            return json.toString();
        }
    }

    public static JSONObject getJson(URL url) throws Exception {
        String json = IOUtils.toString(url, Charset.forName("UTF-8"));
        return new JSONObject(json);
    }

}
