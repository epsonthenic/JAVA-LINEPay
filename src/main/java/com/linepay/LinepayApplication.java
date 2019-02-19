package com.linepay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class LinepayApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(LinepayApplication.class, args);
        LINEPay.request();

    }

}

