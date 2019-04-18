package at.nacs.drhouseadministration.ui.controllers;

import at.nacs.drhouseadministration.communication.AccountancyClient;
import at.nacs.drhouseadministration.ui.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {
    private final AccountancyClient client;

    @ModelAttribute("invoices")
    List<Invoice> invoices() {
        return client.getAll();
    }

    @GetMapping
    String page() {
        return "accountancy/invoice-page";
    }

    @PostMapping()
    String post(Long id) {

        client.markAsPaid(id);
        return "redirect:/";
    }


}
