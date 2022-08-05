package com.lzh.bean;

import java.sql.Date;

public class Stu {
    private int id;
    private String name;
    private String dt;
    private int hid;

    public Stu(int id, String name, String dt, int hid) {
        this.id = id;
        this.name = name;
        this.dt = dt;
        this.hid = hid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public Stu() {
    }

    @Override
    public String toString() {
        return "Stu [id=" + id + ", name=" + name + ", dt=" + dt + ", hid=" + hid + "]";
    }

}