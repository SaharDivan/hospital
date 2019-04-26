package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.persistance.domain.Patient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AccountancyClient { // 9003

    private final RestTemplate restTemplate;

    @Value("${accountancy.server.url}")
    @Getter
    private String url; // http://localhost:9005/patients

    public Patient forwardToAccountancy(Patient patient) {
       return restTemplate.postForObject(url, patient, Patient.class); // ERROR ... responds string, not object!
    }

}
