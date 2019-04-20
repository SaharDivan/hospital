package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.communication.DiagnosesClient;
import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminAssistance {
    private final DiagnosesClient client;

    public void register(Patient patient) {
        patient.setId(UUID.randomUUID().toString());
        client.forwardToDiagnoseRoom(patient);
    }
}
