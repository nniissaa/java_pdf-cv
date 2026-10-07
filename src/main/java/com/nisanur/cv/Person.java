package com.nisanur.cv;

import java.util.List;

public class Person {
    private final String fullName;
    private final String title;
    private final String email;
    private final String phone;
    private final String city;
    private final String summary;
    private final String photoPath;
    private final List<String> skills;
    private final List<Education> education;
    private final List<Experience> experiences;

    public Person(
            String fullName,
            String title,
            String email,
            String phone,
            String city,
            String summary,
            String photoPath,
            List<String> skills,
            List<Education> education,
            List<Experience> experiences) {

        this.fullName = fullName;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.summary = summary;
        this.photoPath = photoPath;
        this.skills = skills;
        this.education = education;
        this.experiences = experiences;
    }

    public String getFullName() { return fullName; }
    public String getTitle() { return title; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getCity() { return city; }
    public String getSummary() { return summary; }
    public String getPhotoPath() { return photoPath; }
    public List<String> getSkills() { return skills; }
    public List<Education> getEducation() { return education; }
    public List<Experience> getExperiences() { return experiences; }
}
