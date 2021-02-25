package com.jlochoam.atcvapi.service.impl;

import com.jlochoam.atcvapi.exception.InvalidFormatException;
import com.jlochoam.atcvapi.exception.MissingRequiredFieldException;
import com.jlochoam.atcvapi.model.cv.*;
import com.jlochoam.atcvapi.service.CVValidation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CVValidationImpl implements CVValidation {
    public void validate(CV cv) throws MissingRequiredFieldException, InvalidFormatException {
        String reqFieldMessage = "is a required field";
        String invFormMessage = "is in an invalid format";
        if(cv.getFirstName() == null || "".equals(cv.getFirstName())) {
            throw new MissingRequiredFieldException("First name " + reqFieldMessage);
        }
        if(cv.getLastName() == null || "".equals(cv.getLastName())) {
            throw new MissingRequiredFieldException("Last name " + reqFieldMessage);
        }
        if(cv.getEmail() == null || "".equals(cv.getEmail())) {
            throw new MissingRequiredFieldException("Email " + reqFieldMessage);
        }
        cv.setEmail(cv.getEmail().toLowerCase());
        Pattern emailPattern = Pattern.compile("^[a-z0-9_\\.\\-]+@[a-z0-9]+(?:\\.[a-z0-9]+)+$", Pattern.CASE_INSENSITIVE);
        Matcher emailMatcher = emailPattern.matcher(cv.getEmail());
        if(!emailMatcher.find()) {
            throw new InvalidFormatException("Email " + invFormMessage);
        }
        if(cv.getPhoneNumber() != null || !"".equals(cv.getPhoneNumber())) {
            Pattern phonePattern = Pattern.compile("^[0-9]{10}$");
            Matcher phoneMatcher = phonePattern.matcher(cv.getPhoneNumber());
            if(!phoneMatcher.find()) {
                throw new InvalidFormatException("Phone number " + invFormMessage);
            }
        }
        if(cv.getCity() == null || "".equals(cv.getCity())) {
            throw new MissingRequiredFieldException("Living city " + reqFieldMessage);
        }
        if(cv.getCountry() == null || "".equals(cv.getCountry())) {
            throw new MissingRequiredFieldException("Living country " + reqFieldMessage);
        }
        if(cv.getSkills() != null) {
            List<Skill> skills = cv.getSkills();
            for(int i = 0; i < skills.size(); i++) {
                if(skills.get(i).getName() == null || "".equals(skills.get(i).getName())) {
                    throw new MissingRequiredFieldException("Skill name " + reqFieldMessage);
                }
                if(skills.get(i).getPercentage() <= 0 || skills.get(i).getPercentage() > 100) {
                    throw new InvalidFormatException("Skill percentage for " + skills.get(i).getName() + " skill " + invFormMessage);
                }
            }
        }
        if(cv.getLanguages() != null) {
            List<Language> languages = cv.getLanguages();
            for(int i = 0; i < languages.size(); i++) {
                if(languages.get(i).getName() == null || "".equals(languages.get(i).getName())) {
                    throw new MissingRequiredFieldException("Language name " + reqFieldMessage);
                }
                if(languages.get(i).getPercentage() <= 0 || languages.get(i).getPercentage() > 100) {
                    throw new InvalidFormatException("Language percentage for " + languages.get(i).getName() + " language " + invFormMessage);
                }
            }
        }
        if(cv.getWorkexperience() != null) {
            List<WorkExperience> workExperiences = cv.getWorkexperience();
            for(int i = 0; i < workExperiences.size(); i++) {
                if(workExperiences.get(i).getTitle() == null || "".equals(workExperiences.get(i).getTitle())) {
                    throw new MissingRequiredFieldException("Role name " + reqFieldMessage);
                }
                if(workExperiences.get(i).getCompany() == null || "".equals(workExperiences.get(i).getCompany())) {
                    throw new MissingRequiredFieldException("Company name " + reqFieldMessage);
                }
                if(workExperiences.get(i).getFrom() == null || "".equals(workExperiences.get(i).getFrom())) {
                    throw new MissingRequiredFieldException("Starting work date for job " + workExperiences.get(i).getTitle() + " at " + workExperiences.get(i).getCompany() + " " + reqFieldMessage);
                }
                if(!workExperiences.get(i).getCurrent()) {
                    if(workExperiences.get(i).getTo() == null || "".equals(workExperiences.get(i).getTo())) {
                        throw new MissingRequiredFieldException("Finishing work date for job " + workExperiences.get(i).getTitle() + " at " + workExperiences.get(i).getCompany() + " " + reqFieldMessage + " because it's not a current job");
                    }
                }
            }
        }
        if(cv.getEducation() != null) {
            List<Education> education = cv.getEducation();
            for(int i = 0; i < education.size(); i++) {
                if(education.get(i).getName() == null || "".equals(education.get(i).getName())) {
                    throw new MissingRequiredFieldException("School name " + reqFieldMessage);
                }
                if(education.get(i).getCareer() == null || "".equals(education.get(i).getCareer())) {
                    throw new MissingRequiredFieldException("The career you studied at " + education.get(i).getName() + " " + reqFieldMessage);
                }
                if(education.get(i).getFrom() == null || "".equals(education.get(i).getFrom())) {
                    throw new MissingRequiredFieldException("Starting date of your career at " + education.get(i).getName() + " " + reqFieldMessage);
                }
                if(education.get(i).getTo() == null || "".equals(education.get(i).getTo())) {
                    throw new MissingRequiredFieldException("Finishing date of your career at " + education.get(i).getName() + " " + reqFieldMessage);
                }
                if(education.get(i).getDegree() == null || "".equals(education.get(i).getDegree())) {
                    throw new MissingRequiredFieldException("The degree of your career at " + education.get(i).getName() + " " + reqFieldMessage);
                }
                if(!education.get(i).getDegree().equals("Bachelor") && !education.get(i).getDegree().equals("Master") && !education.get(i).getDegree().equals("Ph")) {
                    throw new InvalidFormatException("Degree for your career at " + education.get(i).getName() + " should be either 'Bachelor', 'Master', or 'Ph'");
                }
            }
        }
        return;
    }
}
