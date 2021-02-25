package com.jlochoam.atcvapi.model.cv;

public class Skill {
    private String name;
    private byte percentage;

    public Skill(String name, byte percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return this.name;
    }

    public byte getPercentage() {
        return this.percentage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPercentage(byte percentage) {
        this.percentage = percentage;
    }
}
