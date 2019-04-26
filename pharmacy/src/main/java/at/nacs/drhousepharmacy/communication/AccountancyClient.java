package at.nacs.drhousepharmacy.communication;

import at.nacs.drhousepharmacy.persistence.domain.Patient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AccountancyClient {

    private final RestTemplate restTemplate;

    @Getter
    @Value("${accountancy.server.url}")
    private String url;

    public Patient forwardToAccountancy(Patient patient){
      return restTemplate.postForObject(url,patient,Patient.class);
    }
}


