package pl.coderslab.charity.controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;



//@RestController
@org.springframework.web.bind.annotation.RestController

public class RestController {

    private final InstitutionService institutionService;
    private final DonationService donationService;



    public RestController (InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;

    }
    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions",institutionService.findAllInstitutions());
        model.addAttribute("numberOfBags",donationService.sumOfBags());
        model.addAttribute("numberOfInstitutions", donationService.sumOfDonatedInstitutions());
        return "index";
    }

}

