package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistance.domian.Invoice;
import at.nacs.drhouseaccountancy.persistance.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InvoiceManager {

    private final InvoiceRepository invoiceRepository;

    public void storeInvoiceToDb(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public List<Invoice> find() {
        return invoiceRepository.findAll();
    }

    public void setTheInvoiceAsPaid(Long id) {
        Invoice invoice = invoiceRepository.findById(id).get();
        invoice.setPaid(true);
        invoiceRepository.save(invoice);
    }
}
