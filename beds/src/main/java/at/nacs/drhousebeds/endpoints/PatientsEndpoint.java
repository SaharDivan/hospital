package at.nacs.drhousebeds.endpoints;

import at.nacs.drhousebeds.domain.Patient;
import at.nacs.drhousebeds.logics.Nurse;
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
    private final ForwardClass forwardClass;


    @PostMapping
    public Patient bedsRegistry(@RequestBody Patient patient) {
        Patient handledPatient = nurse.provideTreatments(patient);
        forwardClass.forwardToAccountancy(handledPatient);
        return handledPatient;
    }

}
