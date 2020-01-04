package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.domain.repositories.UserRepository;
import pl.coderslab.charity.dtos.RegistrationDTO;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;
import pl.coderslab.charity.services.RegistrationService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final RegistrationService registrationService;
    private final UserRepository userRepository;
    private final InstitutionService institutionService;
    private final DonationService donationService;



    public AdminController(RegistrationService registrationService, UserRepository userRepository, InstitutionService institutionService, DonationService donationService) {
        this.registrationService = registrationService;
        this.userRepository = userRepository;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping
    public String getAdminPage (Principal principal, Model model) {
        String name = principal.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("admin", user);
        model.addAttribute("institutions",institutionService.findAllInstitutions());
        model.addAttribute("numberOfBags",donationService.sumOfBags());
        model.addAttribute("numberOfInstitutions", donationService.sumOfDonatedInstitutions());
        return "admin/admin-main";

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



