package com.linepay;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConstantVariable {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
    public static String APPLICATION_VERSION_CURRENT = "v.1.0."+sdf.format(new Date());
}
