package com.jlochoam.atcvapi.controller;

import com.jlochoam.atcvapi.exception.CVNotFoundException;
import com.jlochoam.atcvapi.exception.InvalidFormatException;
import com.jlochoam.atcvapi.exception.MissingRequiredFieldException;
import com.jlochoam.atcvapi.model.PostResponse;
import com.jlochoam.atcvapi.model.cv.CV;
import com.jlochoam.atcvapi.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cv-api/cv")
public class CVController {

    @Autowired
    private CVService cvService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CV> getCVs() {
        return cvService.getCVs();
    }

    @GetMapping("/{resourceId}")
    @ResponseStatus(HttpStatus.OK)
    public CV getCVByResourceId(@PathVariable String resourceId) {
        try {
            return cvService.getCVByResourceId(resourceId);
        }
        catch(CVNotFoundException cvnfe) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, cvnfe.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponse createCV(@RequestBody CV newCv) {
        try {
            return cvService.createCV(newCv);
        }
        catch (MissingRequiredFieldException | InvalidFormatException err) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, err.getMessage());
        }
    }

    @PutMapping("/{resourceId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCV(@RequestBody CV cv, @PathVariable String resourceId) {
        try {
            cvService.updateCV(cv, resourceId);
        }
        catch(CVNotFoundException cvnfe) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, cvnfe.getMessage());
        }
        catch(MissingRequiredFieldException | InvalidFormatException err) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, err.getMessage());
        }
    }
}
