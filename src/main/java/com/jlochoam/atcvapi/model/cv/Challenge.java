package com.jlochoam.atcvapi.model.cv;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Challenge {
    private final String name;
    private final Date date;
    private final String description;
    private final String url;
}
