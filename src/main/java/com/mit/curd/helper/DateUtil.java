package com.mit.curd.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
        } catch (Exception e) {
            return null; // Handle error properly
        }
    }
}
