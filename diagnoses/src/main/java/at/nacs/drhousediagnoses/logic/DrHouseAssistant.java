package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.communication.PatientTransferClient;
import at.nacs.drhousediagnoses.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrHouseAssistant {
    private final List<String> severcases;
    private final PatientTransferClient client;

    public void forwardToRelevantDepartment(Patient patient) {
        if (severcases.contains(patient.getDiagnoses())) {
            client.sendToBeds(patient);
        }
        client.sendToPharmacy(patient);
    }
}
