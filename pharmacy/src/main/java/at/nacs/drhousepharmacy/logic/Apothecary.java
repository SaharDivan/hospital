package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.domain.Patient;
import at.nacs.drhousepharmacy.persistence.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class Apothecary {

    private final Map<String,String> prescription;
    private final PatientRepository repository;

    public Patient provideMedicine(Patient patient) {
        Stream.of(patient)
                .map(Patient::getDiagnosis)
                .map(prescription::get)
                .peek(e -> patient.setMedicine(e))
                .forEach(e -> repository.save(patient));
        return patient;
    }
}
