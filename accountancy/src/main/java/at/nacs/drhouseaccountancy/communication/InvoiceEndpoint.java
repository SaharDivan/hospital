package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.logic.InvoiceManager;
import at.nacs.drhouseaccountancy.persistance.domian.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceEndpoint {

    private final InvoiceManager invoiceManager;

    @GetMapping
    List<Invoice> findAllInvoices() {
        return invoiceManager.find();
    }

    @PutMapping("/{id}/paid")
    void sendToMarkAsPaid(@PathVariable Long id) {
        invoiceManager.setTheInvoiceAsPaid(id);
    }
}
