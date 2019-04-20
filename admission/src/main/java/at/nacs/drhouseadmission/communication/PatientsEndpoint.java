package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.domain.Patient;
import at.nacs.drhouseadmission.logic.AdminAssistance;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

    private final AdminAssistance adminAssistance;

    @PostMapping
    public Patient post(@RequestBody Patient patient) {
        adminAssistance.register(patient);
        return patient;
    }
}
