package at.nacs.drhousediagnoses.logic;


import at.nacs.drhousediagnoses.domain.Patient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("endpoints.illnesses")
@Log
public class DrHouse {

    @Getter
    private final Map<String, String> diagnoses;

    public Patient diagnose(Patient patient) {
        if (isDrRecognizeTheIllness(patient)) {
            patient.setDiagnoses(assignDiagnose(patient));
            return patient;
        }
        patient.setDiagnoses("lupus");
        return patient;
    }


    private Boolean isDrRecognizeTheIllness(Patient patient) {
        String symptoms = patient.getSymptoms();
        return diagnoses.containsKey(symptoms);
    }

    private String assignDiagnose(Patient patient) {
        String symptoms = patient.getSymptoms();
        return diagnoses.get(symptoms);
    }
}
