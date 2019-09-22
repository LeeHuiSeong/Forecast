package com.example.geolocation;

public class Structure {
    public String pop = "";
    public String temp = "";
    public String r12 = "";
    public String hour = "";
    public String tmn = "";
    public String reh = "";
    public String s12 = "";
    public String ws = "";
    public String day = "";
    public String tmx = "";
    public String wdKor = "";

    public void setValue(String category, String Value)
    {
        if (category.equals("hour")) {
            hour = Value;
        }
        if (category.equals("pop")) {
            pop = Value;
        }
        if (category.equals("temp")) {
            temp = Value;
        }
        if (category.equals("r12")) {
            r12 = Value;
        }
        if (category.equals("tmn")) {
            tmn = Value;
        }
        if (category.equals("reh")) {
            reh = Value;
        }
        if (category.equals("s12")) {
            s12 = Value;
        }
        if (category.equals("ws")) {
            ws= Value;
        }
        if (category.equals("day")) {
            day = Value;
        }
        if (category.equals("tmx")) {
            tmx = Value;
        }
        if (category.equals("wdKor")) {
            wdKor = Value;
        }
    }
    public String getValue(String category)
    {
        if (category.equals("hour")) {
            return hour;
        }
        if (category.equals("pop")) {
            return pop;
        }
        if (category.equals("temp")) {
            return temp;
        }
        if (category.equals("r12")) {
            return r12;
        }
        if (category.equals("tmn")) {
            return tmn;
        }
        if (category.equals("reh")) {
            return reh;
        }
        if (category.equals("s12")) {
            return s12;
        }
        if (category.equals("ws")) {
            return ws;
        }
        if (category.equals("day")) {
            return day;
        }
        if (category.equals("tmx")) {
            return tmx;
        }
        if (category.equals("wdKor")) {
            return wdKor;
        }
        return "잘못된 입력";
    }

}
