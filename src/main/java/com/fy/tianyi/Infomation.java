package com.fy.tianyi;

/**
 * @Classname Infomation
 * @Description TODO
 * @Date 2021/6/16 16:44
 * @Created by fy
 */

/*
* 封装平台传过来的数据
* */
public class Infomation {
    private String uptime;
    private float humidity;
    private float temperature;
    private String desc = "OK";

    public String getUptime() {
        return uptime;
    }

    public void setUptime(long uptime) {
        this.uptime = TimestampConverter.stampToDate(uptime);
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
