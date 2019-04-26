package at.nacs.drhouseadministration.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/accountant")
public class AccountantController {

    @ModelAttribute("principal")
    Principal principal(Principal principal) {
        return principal;
    }

    @GetMapping
    String page() {
        return "accountancy/accountant";
    }
}
