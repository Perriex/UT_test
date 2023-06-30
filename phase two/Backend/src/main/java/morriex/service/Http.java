package morriex.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.String;
import java.net.URL;
import java.net.URLConnection;

public class Http {
    private static String base = "http://138.197.181.131:5000/api/";

    public static String Get(String key) {
        try {
            URL url = new URL(base + key);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;
            String output = "";
            while ((inputLine = in.readLine()) != null)
                output += inputLine;
            in.close();
            return output;
        } catch (Exception e) {
            System.exit(0);
        }
        return "";
    }

}
