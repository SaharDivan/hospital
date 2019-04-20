package at.nacs.drhouseadministration.communication;

import at.nacs.drhouseadministration.ui.model.Patient;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AdmissionClient {

    private final RestTemplate restTemplate;

    @Value("${admission.address.url}")
    @Setter
    private String url;

    public Patient send(Patient patient) {
       return restTemplate.postForObject(url,patient,Patient.class);
    }
}
