package com.jlochoam.atcvapi.model.cv;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Challenge {
    private String name;
    private Date date;
    private String description;
    private String url;

    public Challenge(String name, Date date, String description, String url) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        if(this.date != null) {
            return new SimpleDateFormat("MMM YYYY").format(this.date);
        }
        return null;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
