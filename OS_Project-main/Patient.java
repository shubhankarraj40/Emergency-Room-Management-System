package com.example.demo;

import java.util.Date;

public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String medicalCondition;
    private int urgency;
    private String timeAttended;

    public Patient(int id, String firstName, String lastName, String dateOfBirth, String medicalCondition, int urgency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.medicalCondition = medicalCondition;
        this.urgency = urgency;
        this.timeAttended = null;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public int getUrgency() {
        return urgency;
    }

    public void setTimeAttended() {
        this.timeAttended = new Date().toString();
    }

    public String getTimeAttended() {
        return timeAttended;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + firstName + " " + lastName + ", DOB: " + dateOfBirth +
               ", Condition: " + medicalCondition + ", Urgency: " + urgency +
               ", Time Attended: " + (timeAttended != null ? timeAttended : "Not yet attended");
    }
}
