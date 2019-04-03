package at.nacs.drhousepharmacy.communication;

import at.nacs.drhousepharmacy.persistence.domain.Patient;
import at.nacs.drhousepharmacy.logic.Apothecary;
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

    @Value("${accountancy.server.url}")
    private String url;

    private final Apothecary apothecary;
    private final RestTemplate restTemplate;


    @PostMapping
    Patient pharmacyRegistry(@RequestBody Patient patient){
        Patient handledPatient = apothecary.provideMedicine(patient);
        forwardToAccountancy(handledPatient);
        return handledPatient;
    }

    String forwardToAccountancy(Patient patient){
        restTemplate.postForObject(url,patient,Patient.class);
        return "Patient is sent to accountancy.";
    }
}
