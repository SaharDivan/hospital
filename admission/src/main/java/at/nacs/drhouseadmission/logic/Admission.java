package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Admission {

    public void admit(Patient patient) {
        patient.setId(UUID.randomUUID().toString());
    }
}