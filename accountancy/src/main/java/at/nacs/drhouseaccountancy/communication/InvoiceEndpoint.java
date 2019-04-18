package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.persistance.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistance.domian.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceEndpoint {

    private final InvoiceRepository invoiceRepository;

    @GetMapping
    List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll();
    }

    @PutMapping("/{id}/paid")
    void setTheInvoiceAsPaid(@PathVariable Long id) {
        Invoice invoice = invoiceRepository.findById(id).get();
        invoice.setPaid(true);
        invoiceRepository.save(invoice);
    }


}
