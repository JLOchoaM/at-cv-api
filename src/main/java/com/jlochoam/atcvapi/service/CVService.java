package com.jlochoam.atcvapi.service;

import com.jlochoam.atcvapi.exception.CVNotFoundException;
import com.jlochoam.atcvapi.exception.InvalidFormatException;
import com.jlochoam.atcvapi.exception.MissingRequiredFieldException;
import com.jlochoam.atcvapi.model.PostResponse;
import com.jlochoam.atcvapi.model.cv.CV;

import java.util.List;

public interface CVService {
    public List<CV> getCVs();
    public CV getCVByResourceId(String resourceId) throws CVNotFoundException;
    public PostResponse createCV(CV cv) throws MissingRequiredFieldException, InvalidFormatException;
    public void updateCV(CV cv, String resourceId) throws MissingRequiredFieldException, CVNotFoundException, InvalidFormatException;
}
