package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class DiagnosesClient {
    private final RestTemplate restTemplate;

    @Value("${diagnoses.server.url}")
    @Getter
    private String url;

    public Patient forwardToDiagnoseRoom(Patient patient) {
        return restTemplate.postForObject(url, patient, Patient.class);
    }
}
