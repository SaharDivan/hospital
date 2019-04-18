package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistance.domian.Invoice;
import at.nacs.drhouseaccountancy.persistance.domian.Kind;
import at.nacs.drhouseaccountancy.persistance.domian.Patient;
import at.nacs.drhouseaccountancy.persistance.dto.PatientDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoiceIssuer {

    private final AccountancyCalculator calculator;


    public Invoice issueInvoice(PatientDTO dto) {
        Double cost = calculator.calculateCostForPatient(dto);
        Kind kind = Kind.Treatment;

        return Invoice.builder()
                .patient(Patient.builder()
                        .uuid(dto.getId())
                        .name(dto.getName())
                        .build())
                .diagnosis(dto.getDiagnosis())
                .provided(dto.getTreatment())
                .symptoms(dto.getSymptoms())
                .kind(kind)
                .symptoms(dto.getSymptoms())
                .cost(cost)
                .build();
    }
}
