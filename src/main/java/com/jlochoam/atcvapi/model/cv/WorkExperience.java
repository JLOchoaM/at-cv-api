package com.jlochoam.atcvapi.model.cv;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkExperience {
    private String title;
    private String company;
    private Date from;
    private Date to;
    private Boolean current;
    private String description;

    public WorkExperience(String title, String company, Date from, Date to, Boolean current, String description) {
        this.title = title;
        this.company = company;
        this.from = from;
        this.to = to;
        this.current = current;
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFrom() {
        if(this.from != null) {
            return new SimpleDateFormat("MMM YYYY").format(this.from);
        }
        return null;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public String getTo() {
        if(this.to != null) {
            return new SimpleDateFormat("MMM YYYY").format(this.to);
        }
        return null;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Boolean getCurrent() {
        return this.current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
