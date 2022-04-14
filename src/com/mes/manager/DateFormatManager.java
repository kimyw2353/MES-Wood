package com.mes.manager;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateFormatManager {

    public String dateFormat(Timestamp timestamp){
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        return date.format(timestamp);
    }

    public String dateFormat(String timestamp){
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        return date.format(timestamp);
    }

    public String splitDate(String timestamp){
        return timestamp.substring(0,10);
    }





}
