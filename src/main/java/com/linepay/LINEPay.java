package com.linepay;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class LINEPay {
    public static String transactionId;
    public static String web;

//    public static void main(String... args) {
//        LINEPay.request();
//        LINEPay.confirm();
//    }

    public static void request() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("productName", "สินค้าทดสอบ");
        data.put("productImageUrl", "http://52.25.22.65:8005/api105/product.png");
        data.put("amount", "1");
        data.put("currency", "THB");
        data.put("orderId", "16"); // เปลี่ยนเลื่อยๆ
        data.put("confirmUrl", "http://localhost:8080/appUsers/confirm");
        data.put("cancelUrl", "http://localhost:8080/appUsers/cancel");
        data.put("capture", "true");
        data.put("confirmUrlType", "CLIENT");

//        data.put("productName", "สินค้าทดสอบ");
//	data.put("checkConfirmUrlBrowser","false");
//	data.put("productImageUrl", "https://line.ohmygodzilla.me/img/product.png");
//	data.put("amount", "1");
//	data.put("currency", "THB");
//	data.put("orderId", "20190214072244");
//	data.put("confirmUrl", "https://line.ohmygodzilla.me/page_confirm.php");
//	data.put("cancelUrl", "https://line.ohmygodzilla.me/page_cancel.php");
//	data.put("capture", "true");
//	data.put("confirmUrlType", "SERVER");

        JSONObject jObj = LINEPayAPI.request("https://api-pay.line.me/v2/payments/request", data);

        try {
            System.out.println("");
            System.out.println("returnCode=>" + jObj.getString("returnCode"));
            System.out.println("");
            JSONObject infoOjb = jObj.getJSONObject("info");
            JSONObject payOjb = infoOjb.getJSONObject("paymentUrl");
            System.out.println("paymentUrl.web=>" + payOjb.getString("web"));
            web = payOjb.getString("web");
            System.out.println("");
            System.out.println("paymentUrl.app=>" + payOjb.getString("app"));
            System.out.println("");
            System.out.println("transactionId=>" + infoOjb.get("transactionId").toString());
            transactionId = infoOjb.get("transactionId").toString();
            System.out.println("");
            System.out.println("paymentAccessToken=>" + infoOjb.get("paymentAccessToken").toString());
            System.out.println("");
        } catch (JSONException ex) {
            Logger.getLogger(LINEPay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
