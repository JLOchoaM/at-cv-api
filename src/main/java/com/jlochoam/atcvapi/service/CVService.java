package com.jlochoam.atcvapi.service;

import com.jlochoam.atcvapi.exception.CVNotFoundException;
import com.jlochoam.atcvapi.exception.InvalidFormatException;
import com.jlochoam.atcvapi.exception.MissingRequiredFieldException;
import com.jlochoam.atcvapi.model.PostResponse;
import com.jlochoam.atcvapi.model.cv.CV;

import java.util.List;

public interface CVService {
    public List<CV> getAllCvs();
    public CV getCvByResourceId(String resourceId) throws CVNotFoundException;
    public PostResponse createCv(CV cv) throws MissingRequiredFieldException, InvalidFormatException;
    public void updateCv(CV cv, String resourceId) throws MissingRequiredFieldException, CVNotFoundException, InvalidFormatException;
}
