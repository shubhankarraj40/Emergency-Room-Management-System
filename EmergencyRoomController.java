package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmergencyRoomController {

    private final PatientService patientService;

    @Autowired
    public EmergencyRoomController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/checkIn")
    @ResponseBody
    public String checkInPatient(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String dob,
            @RequestParam String condition,
            @RequestParam int urgency) {
        patientService.checkInPatient(firstName, lastName, dob, condition, urgency);
        return "Patient " + firstName + " " + lastName + " has been checked in.";
    }

    @GetMapping("/attendNext")
    @ResponseBody
    public String attendNextPatient() {
        Patient patient = patientService.attendNextPatient();
        if (patient == null) {
            return "No patients in the queue to attend.";
        }
        return "Attending to patient: " + patient.getFirstName();
    }

    @GetMapping("/patientLog")
    @ResponseBody
    public List<Patient> getPatientLog() {
        return patientService.getPatientLog();
    }
}
