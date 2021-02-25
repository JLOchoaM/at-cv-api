package com.jlochoam.atcvapi.service;

import com.jlochoam.atcvapi.exception.InvalidFormatException;
import com.jlochoam.atcvapi.exception.MissingRequiredFieldException;
import com.jlochoam.atcvapi.model.cv.CV;

public interface CVValidation {
    public void validate(CV cv) throws MissingRequiredFieldException, InvalidFormatException;
}
