package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.logic.Accountant;
import at.nacs.drhouseaccountancy.persistance.domian.Patient;
import at.nacs.drhouseaccountancy.persistance.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")

@RequiredArgsConstructor
public class PatientEndpoint {
    private final Accountant accountant;

    @PostMapping
    public Patient passDTOToAccountancyDepartments(@RequestBody PatientDTO dto) {
      // return new Patient((long)34567,"123","Tuma");
      return accountant.administerTheAccount(dto);
    }
}
