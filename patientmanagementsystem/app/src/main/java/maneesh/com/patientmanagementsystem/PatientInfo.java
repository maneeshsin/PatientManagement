package maneesh.com.patientmanagementsystem;

import java.util.Date;

/**
 * Created by manish on 7/24/17.
 */

public class PatientInfo {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private Integer age;
    private String gender;
    private String address;
    private String bloodGroup;
    private String condition;
    private String medication;
    private String note;
    private Date lastVisited;
    private static final String EMPTY_STRING = "";

    void PatientInfo() {
        firstName = null;
        lastName = null;
        email = null;
        mobileNumber = null;
        age = null;
        gender = null;
        address = null;
        bloodGroup = null;
        condition = null;
        medication = null;
        note = null;
        lastVisited = null;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String address) {
        this.bloodGroup = bloodGroup;
    }

    public String getCondition() {
        if (condition == null) {
            condition = EMPTY_STRING;
        }
        return condition;
    }

    public void setCondition(String address) {
        this.condition = condition;
    }

    public String getMedication() {

        if (medication == null) {
            medication = EMPTY_STRING;
        }
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getNote() {
        if (note == null) {
            note = EMPTY_STRING;
        }
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getLastVisited() {

        if (lastVisited == null) {
            lastVisited = new Date();
        }
        return lastVisited;
    }

    public void setlastVisited(Date lastVisited) {
        this.lastVisited = lastVisited;
    }

}
