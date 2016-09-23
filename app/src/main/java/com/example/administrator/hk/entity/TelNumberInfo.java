package com.example.administrator.hk.entity;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class TelNumberInfo {
    private final String name;
    private final String number;

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public TelNumberInfo(String name, String number) {

        this.name = name;
        this.number = number;
    }
}
