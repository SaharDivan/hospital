package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistance.domian.Invoice;
import at.nacs.drhouseaccountancy.persistance.domian.Kind;
import at.nacs.drhouseaccountancy.persistance.domian.Patient;
import at.nacs.drhouseaccountancy.persistance.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InvoiceIssuer {

    private final AccountancyCalculator calculator;
    private final PatientManager patientManager;


    public Invoice issueInvoice(PatientDTO dto) {
        return Invoice.builder()
                .patient(setPatient(dto))
                .diagnosis(dto.getDiagnosis())
                .provided(dto.getTreatment())
                .symptoms(dto.getSymptoms())
                //.kind(assignTheKind(dto))
                .cost(calculator.calculateCostForPatient(dto))
                .build();
    }

    private Kind assignTheKind(PatientDTO dto) {
        if (dto.getTreatment().isEmpty()) {
            return Kind.Medicine;
        }
        return Kind.Treatment;
    }

    private Patient setPatient(PatientDTO dto) {
       return patientManager.saveOrUpdatePatient(dto);
    }
}
