package com.linepay;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class LINEPayAPI {

    static String channelId = "1646099554";
    static String channelSecret = "636b9ef681cb68a076badd11c0381c8e";

    public static JSONObject request(String strUrl, Map data) {
        try {
            System.out.println("Sending POST to LINE Pay");
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("X-LINE-ChannelId", LINEPayAPI.channelId);
            conn.setRequestProperty("X-LINE-ChannelSecret", LINEPayAPI.channelSecret);
            conn.setDoOutput(true);
            ObjectMapper mapper = new ObjectMapper();

            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            mapper.writeValue((DataOutput) wr,data);
            wr.flush();
            wr.close();

            int responseCode = conn.getResponseCode();
//            System.out.println("\nSending 'POST' request to URL : " + url);
//            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
            JSONObject jObject = null;
            try {
                jObject = new JSONObject(response.toString());
            } catch (JSONException ex) {
                Logger.getLogger(LINEPayAPI.class.getName()).log(Level.SEVERE, null, ex);
            }
            return jObject;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
