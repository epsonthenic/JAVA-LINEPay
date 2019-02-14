package com.linepay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class LinepayApplication {
//    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
//    public static String APPLICATION_VERSION_CURRENT = "v.1.0."+sdf.format(new Date());

    public static void main(String[] args)
    {
        SpringApplication.run(LinepayApplication.class, args);

//        LINEPay.request();
//        LINEPay.confirm();
    }

}

