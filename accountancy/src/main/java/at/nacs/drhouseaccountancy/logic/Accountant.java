package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistance.domian.Invoice;
import at.nacs.drhouseaccountancy.persistance.domian.Patient;
import at.nacs.drhouseaccountancy.persistance.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Accountant {

    private final InvoiceIssuer invoiceIssuer;
    private final InvoiceManager invoiceManager;

    public Patient administerTheAccount(PatientDTO dto) {
        Invoice invoice = invoiceIssuer.issueInvoice(dto);
        invoiceManager.storeInvoiceToDb(invoice);
           return invoice.getPatient();
    }

}
