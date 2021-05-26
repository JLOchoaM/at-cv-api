package com.jlochoam.atcvapi.service.impl;

import com.jlochoam.atcvapi.exception.CVNotFoundException;
import com.jlochoam.atcvapi.exception.InvalidFormatException;
import com.jlochoam.atcvapi.exception.MissingRequiredFieldException;
import com.jlochoam.atcvapi.model.PostResponse;
import com.jlochoam.atcvapi.model.cv.CV;
import com.jlochoam.atcvapi.repository.CVRepository;
import com.jlochoam.atcvapi.service.CVService;
import com.jlochoam.atcvapi.validator.CvValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CVServiceImpl implements CVService {
    @Autowired
    private CVRepository cvRepository;

    @Autowired
    private CvValidator cvValidator;

    @Override
    public List<CV> getAllCvs() {
        return cvRepository.findAll();
    }

    @Override
    public CV getCvByResourceId(String resourceId) {
        Optional<CV> foundCV = cvRepository.findById(resourceId);
        if(foundCV.isPresent()) {
            return foundCV.get();
        }
        throw new CVNotFoundException(String.format("Curriculum Vitae with id %s could not be found.", resourceId));
    }

    @Override
    public PostResponse createCv(CV cv) {
        cvValidator.validate(cv);
        CV createdCv = cvRepository.save(cv);
        return new PostResponse(createdCv.getId());
    }

    @Override
    public void updateCv(CV cv, String resourceId) throws MissingRequiredFieldException, CVNotFoundException, InvalidFormatException {
        if(cvRepository.existsById(resourceId)) {
            cvValidator.validate(cv);
            cv.setId(resourceId);
            cvRepository.save(cv);
            return;
        }
        throw new CVNotFoundException(String.format("Curriculum Vitae with id %s could not be found.", resourceId));
    }
}
