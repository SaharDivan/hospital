package at.nacs.drhousepharmacy.communication;

import at.nacs.drhousepharmacy.logic.ApothecaryAssistant;
import at.nacs.drhousepharmacy.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

    private final ApothecaryAssistant apothecaryAssistant;

    @PostMapping
    public Patient pharmacyRegistry(@RequestBody Patient patient) {
        return apothecaryAssistant.provideMedicine(patient);
    }
}
