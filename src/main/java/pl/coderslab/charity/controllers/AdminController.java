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
@RequestMapping("/admin")
public class AdminController {

    private final RegistrationService registrationService;

    public AdminController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping("/create")
    public String prepareAdminAccount(Model model) {
        model.addAttribute("registerAdmin", new RegistrationDTO());
        return "admin/admin-add";
    }

    @PostMapping("/create")
    public String processAdminAccount(@ModelAttribute("registerAdmin") @Valid RegistrationDTO registrationDTO,
                                        BindingResult result){
        if(result.hasErrors()){
            return "admin/admin-add";
        }
        registrationService.adminRegister(registrationDTO);
        return "redirect:/";
    }
}



