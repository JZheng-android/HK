package com.example.administrator.hk.entity;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class TelClassInfo {
    private final String name;
    private final int idx;

    public int getIdx() {
        return idx;
    }

    public String getName() {
        return name;
    }

    public TelClassInfo(String name, int idx) {

        this.name = name;
        this.idx = idx;
    }
}
