package com.fy.tianyi;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TimestampConverter {
	public static String stampToDate(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time_date = sdf.format(new Date(time));
        return time_date;
	}
}
