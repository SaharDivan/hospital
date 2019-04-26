package at.nacs.drhouseadministration.ui.controllers;

import at.nacs.drhouseadministration.communication.AdmissionClient;
import at.nacs.drhouseadministration.ui.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomePageController {

    private final AdmissionClient client;
    private Patient patient = new Patient();

    @ModelAttribute("patient")
    Patient patient() {
        return patient;
    }

    @GetMapping
    String page() {
        return "admission/index";
    }

    @PostMapping
    String sendToAdmission(@Valid Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return page();
        }
        this.patient = client.send(patient);
        return "redirect:/";
    }


}
