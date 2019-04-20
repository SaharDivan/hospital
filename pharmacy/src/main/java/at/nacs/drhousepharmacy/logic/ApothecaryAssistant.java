package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.communication.AccountancyClient;
import at.nacs.drhousepharmacy.persistence.domain.Patient;
import at.nacs.drhousepharmacy.persistence.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ApothecaryAssistant {

    private final Map<String,String> prescription;
    private final PatientRepository repository;
    private final AccountancyClient client;


    public Patient provideMedicine(Patient patient) {
        Stream.of(patient)
                .map(Patient::getDiagnosis)
                .map(prescription::get)
                .peek(e -> patient.setMedicine(e))
                .forEach(e -> repository.save(patient));
        client.forwardToAccountancy(patient);
        return patient;
    }
}
