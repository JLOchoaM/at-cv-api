package com.jlochoam.atcvapi.model.cv;

public class Config {
    private String fontColor;
    private String fontFamily;
    private String genericFamily;

    public Config(String fontColor, String fontFamily, String genericFamily) {
        this.fontColor = fontColor;
        this.fontFamily = fontFamily;
        this.genericFamily = genericFamily;
    }

    public String getFontColor() {
        return this.fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
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
