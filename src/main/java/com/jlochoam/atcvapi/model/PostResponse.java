package com.jlochoam.atcvapi.model;

import java.util.Date;
import java.util.List;

public class PostResponse{
    private String resourceId;

    public PostResponse(String resourceId) {
        super();
        this.resourceId = resourceId;
    }

    public String getResourceId() {
        return this.resourceId;
    }
}
