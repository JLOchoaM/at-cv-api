package com.jlochoam.atcvapi.model.cv;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Education {
    private final String schoolName;
    private final String career;
    private final Date from;
    private final Date to;
    private final String degree;
}
