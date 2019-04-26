package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.communication.AccountancyClient;
import at.nacs.drhousebeds.persistance.domain.Patient;
import at.nacs.drhousebeds.persistance.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class BedsAssistance {

    private final Map<String, String> book;
    private final PatientRepository repository;
    private final AccountancyClient accountancyClient;

    public Patient provideTreatments(Patient patient) {
        Stream.of(patient)
                .map(Patient::getDiagnosis)
                .map(book::get)
                .peek(e -> patient.setTreatment(e))
                .forEach(e -> repository.save(patient));
        accountancyClient.forwardToAccountancy(patient);
        return patient;
    }
}