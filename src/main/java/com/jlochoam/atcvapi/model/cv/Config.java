package com.jlochoam.atcvapi.model.cv;

public class Config {
    private String color;
    private String fontFamily;
    private String genericFamily;

    public Config(String color, String fontFamily, String genericFamily) {
        this.color = color;
        this.fontFamily = fontFamily;
        this.genericFamily = genericFamily;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFontFamily() {
        return this.fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getGenericFamily() {
        return this.genericFamily;
    }

    public void setGenericFamily(String genericFamily) {
        this.genericFamily = genericFamily;
    }
}
