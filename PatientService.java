package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PriorityQueue<Patient> patientQueue = new PriorityQueue<>(new PatientComparator());
    private final List<Patient> patientLog = new ArrayList<>();
    private int patientIDCounter = 1;

    public void checkInPatient(String firstName, String lastName, String dob, String condition, int urgency) {
        Patient newPatient = new Patient(patientIDCounter++, firstName, lastName, dob, condition, urgency);
        patientQueue.add(newPatient);
    }

    public Patient attendNextPatient() {
        if (patientQueue.isEmpty()) {
            return null;
        }
        Patient nextPatient = patientQueue.poll();
        nextPatient.setTimeAttended();
        patientLog.add(nextPatient);
        return nextPatient;
    }

    public List<Patient> getPatientLog() {
        return new ArrayList<>(patientLog);
    }
}
