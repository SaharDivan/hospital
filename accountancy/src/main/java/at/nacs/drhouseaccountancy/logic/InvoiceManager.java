package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistance.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistance.domian.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class InvoiceManager {

    private final InvoiceRepository invoiceRepository;


    public void storeInvoiceToDb(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public Optional<Invoice> find(String uuid) {
        return invoiceRepository.findById(Long.valueOf(uuid));
    }

    public List<Invoice> find() {
        return invoiceRepository.findAll();
    }
}
