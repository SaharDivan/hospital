package at.nacs.drhouseadmission.endpoints;

import at.nacs.drhouseadmission.domain.Patient;
import at.nacs.drhouseadmission.logic.Admission;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

    private final Admission admission;
    private final RestTemplate restTemplate;

    @Value("${diagnosesBook.server.url}")
    private String url;

    @PostMapping
    public Patient post(@RequestBody Patient patient) {
        admission.admit(patient);
        forwardToDiagnoseRoom(patient);
        return patient;
    }

    public void forwardToDiagnoseRoom(Patient patient) {
        restTemplate.postForObject(url, patient, Patient.class);
    }

}
