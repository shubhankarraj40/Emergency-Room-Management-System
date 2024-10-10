package com.example.demo;
import java.util.Comparator;
public class PatientComparator implements Comparator<Patient> {

    @Override
    public int compare(Patient p1, Patient p2) {
        int urgencyComparison = Integer.compare(p1.getUrgency(), p2.getUrgency());
        if (urgencyComparison == 0) 
        {
            return p1.getTimeAttended().compareTo(p2.getTimeAttended());
        }

        return urgencyComparison;
    }
}
