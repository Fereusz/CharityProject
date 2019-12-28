package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dtos.RegistrationDTO;
import pl.coderslab.charity.services.RegistrationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String prepareRegistrationProcess(Model model) {
        model.addAttribute("registrationDTO", new RegistrationDTO());
        return "register";

    }

    @PostMapping
    public String processRegistrationProcess(@ModelAttribute("registrationDTO") @Valid RegistrationDTO registrationDTO,
                                             BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        registrationService.register(registrationDTO);
        return "redirect:/";
    }
}

