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

    public Patient forwardToRelevantDepartment(Patient patient) {
        if (severcases.contains(patient.getDiagnoses())) {
           return client.sendToBeds(patient);
        }
      return   client.sendToPharmacy(patient);
    }
}
