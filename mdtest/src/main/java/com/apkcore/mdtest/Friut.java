package com.apkcore.mdtest;

public class Friut {
    private String name;
    private int imagId;

    public Friut(String name, int imagId) {
        this.name = name;
        this.imagId = imagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImagId() {
        return imagId;
    }

    public void setImagId(int imagId) {
        this.imagId = imagId;
    }
}
