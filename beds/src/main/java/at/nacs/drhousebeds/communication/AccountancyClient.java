package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.persistance.domain.Patient;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AccountancyClient {

    private final RestTemplate restTemplate;

    @Value("${accountancy.server.url}")
    @Setter
    private String url;

    public Patient forwardToAccountancy(Patient patient) {
       return restTemplate.postForObject(url, patient, Patient.class);
    }

}
