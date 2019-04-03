package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.persistance.domain.Patient;
import at.nacs.drhousebeds.logic.Nurse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

    private final Nurse nurse;
    private final AccountancyClient accountancyClient;


    @PostMapping
    public Patient bedsRegistry(@RequestBody Patient patient) {
        Patient handledPatient = nurse.provideTreatments(patient);
        accountancyClient.forwardToAccountancy(handledPatient);
        return handledPatient;
    }

}
