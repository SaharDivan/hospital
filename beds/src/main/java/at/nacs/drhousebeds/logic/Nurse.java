package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.persistance.domain.Patient;
import at.nacs.drhousebeds.persistance.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class Nurse {

    private final Map<String, String> book;
    private final PatientRepository repository;

    public Patient provideTreatments(Patient patient) {
        Stream.of(patient)
                .map(Patient::getDiagnosis)
                .map(book::get)
                .peek(e -> patient.setTreatment(e))
                .forEach(e -> repository.save(patient));
        return patient;
    }
}