package com.jlochoam.atcvapi.model.cv;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class WorkExperience {
    private final String title;
    private final String company;
    private final Date from;
    private final Date to;
    private final Boolean current;
    private final String description;
}
