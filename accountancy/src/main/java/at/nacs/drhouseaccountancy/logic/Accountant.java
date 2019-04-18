package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistance.domian.Invoice;
import at.nacs.drhouseaccountancy.persistance.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Accountant {

    private final InvoiceIssuer invoiceIssuer;
    private final InvoiceManager invoiceManager;
    private final PatientManager patientManager;

    public void administerTheAccount(PatientDTO dto) {
        patientManager.saveOrUpdatePatient(dto);
        Invoice invoice = invoiceIssuer.issueInvoice(dto);
        invoiceManager.storeInvoiceToDb(invoice);
    }

}
