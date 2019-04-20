package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class DiagnosesClient {
    private final RestTemplate restTemplate;

    @Value("${diagnoses.server.url}")
    @Setter
    private  String url;

    public Patient forwardToDiagnoseRoom(Patient patient) {
     return  restTemplate.postForObject(url, patient, Patient.class);
    }

}
