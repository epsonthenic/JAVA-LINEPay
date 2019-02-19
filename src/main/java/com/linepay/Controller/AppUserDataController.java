package com.linepay.Controller;

import com.linepay.LINEPay;
import com.linepay.LINEPayAPI;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

@RestController
@RequestMapping("/appUsers")
public class AppUserDataController {

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public void confirm(@RequestParam("transactionId") String transactionId) {

        Map<String, String> data = new HashMap<String, String>();
        data.put("amount", "1");
        data.put("currency", "THB");

        System.out.println("transactionId=>"+ transactionId);
        JSONObject jObj = LINEPayAPI.request("https://api-pay.line.me/v2/payments/" + transactionId + "/confirm", data);
        try {
            JSONObject infoOjb = jObj.getJSONObject("info");
            System.out.println("orderId=>" + infoOjb.getString("orderId"));
            System.out.println("transactionId=>" + infoOjb.getString("transactionId"));
            System.out.println("returnCode=>" + jObj.getString("returnCode"));
        } catch (JSONException ex) {
            java.util.logging.Logger.getLogger(LINEPay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
