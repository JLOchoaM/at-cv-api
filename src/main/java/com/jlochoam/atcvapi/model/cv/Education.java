package com.jlochoam.atcvapi.model.cv;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Education {
    private String name;
    private String career;
    private Date from;
    private Date to;
    private String degree;

    public Education(String name, String career, Date from, Date to, String degree) {
        this.name = name;
        this.career = career;
        this.from = from;
        this.to = to;
        this.degree = degree;
    }

    public String getName() {
        return this.name;
    }

    public String getCareer() {
        return this.career;
    }

    public String getFrom() {
        if(this.from != null) {
            return new SimpleDateFormat("MMM YYYY").format(this.from);
        }
        return null;
    }

    public String getTo() {
        if(this.to != null) {
            return new SimpleDateFormat("MMM YYYY").format(this.to);
        }
        return null;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
