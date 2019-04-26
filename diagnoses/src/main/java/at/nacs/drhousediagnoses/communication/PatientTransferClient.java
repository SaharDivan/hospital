package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.domain.Patient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class PatientTransferClient {
    private final RestTemplate restTemplate;

    @Value("${bed.server.url}")
    @Setter
    private String bedUrl;

    @Value("${pharmacy.server.url}")
    @Getter
    private String pharmacyUrl;

    public Patient sendToBeds(Patient patient) {

        return restTemplate.postForObject(bedUrl, patient, Patient.class);
    }

    public Patient sendToPharmacy(Patient patient) {
        return restTemplate.postForObject(pharmacyUrl, patient, Patient.class);
    }
}
