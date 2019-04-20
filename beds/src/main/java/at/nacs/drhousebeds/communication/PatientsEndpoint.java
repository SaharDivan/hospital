package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.logic.BedsAssistance;
import at.nacs.drhousebeds.persistance.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

    private final BedsAssistance bedsAssistance;

    @PostMapping
    public Patient bedsRegistry(@RequestBody Patient patient) {
        return bedsAssistance.provideTreatments(patient);
    }

}
