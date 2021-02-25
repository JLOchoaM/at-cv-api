package com.jlochoam.atcvapi.model.cv;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "CVs")
public class CV {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String job;
    private String city;
    private String country;
    private String email;
    private String phoneNumber;
    private List<Skill> skills;
    private List<Language> languages;
    private List<WorkExperience> workexperience;
    private List<Education> education;
    private List<Challenge> challenges;
    private SocialMedia socialMedia;
    private Config config;

    public CV(String firstName, String lastName, String job, String city, String country, String email, String phoneNumber, List<Skill> skills, List<Language> languages, List<WorkExperience> workexperience, List<Education> education, List<Challenge> challenges, SocialMedia socialMedia, Config config) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.skills = skills;
        this.languages = languages;
        this.workexperience = workexperience;
        this.education = education;
        this.challenges = challenges;
        this.socialMedia = socialMedia;
        this.config = config;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Skill> getSkills() {
        return this.skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Language> getLanguages() {
        return this.languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<WorkExperience> getWorkexperience() {
        return this.workexperience;
    }

    public void setWorkexperience(List<WorkExperience> workexperience) {
        this.workexperience = workexperience;
    }

    public List<Education> getEducation() {
        return this.education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<Challenge> getChallenges() {
        return this.challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public SocialMedia getSocialMedia() {
        return this.socialMedia;
    }

    public void setSocialMedia(SocialMedia socialMedia) {
        this.socialMedia = socialMedia;
    }

    public Config getConfig() {
        return this.config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
}
