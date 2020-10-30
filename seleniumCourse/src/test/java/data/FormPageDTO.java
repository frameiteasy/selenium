package data;

import java.util.Date;

public class FormPageDTO {
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String education;
    private String sex;
    private int experience;
    private Date submitDate;

    public FormPageDTO(String firstNameCase, String lastNameCase, String jobTitleCase, String educationCase,
                       String sexCase, int experienceCase, Date submitDateCase){
        this.firstName = firstNameCase;
        this.lastName = lastNameCase;
        this.jobTitle = jobTitleCase;
        this.education = educationCase;
        this.sex = sexCase;
        this.experience = experienceCase;
        this.submitDate = submitDateCase;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }
}
