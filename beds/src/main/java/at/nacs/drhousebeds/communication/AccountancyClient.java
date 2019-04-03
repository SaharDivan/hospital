package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.persistance.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AccountancyClient {

    private final RestTemplate restTemplate;

    @Value("${accountancy.server.url}")
    private String url;

    public void forwardToAccountancy(Patient patient) {
        restTemplate.postForObject(url, patient, Patient.class);
    }

}
