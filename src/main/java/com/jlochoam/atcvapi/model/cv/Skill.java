package com.jlochoam.atcvapi.model.cv;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Skill {
    private final String name;
    private final byte percentage;
}
