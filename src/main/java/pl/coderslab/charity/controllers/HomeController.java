package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.repositories.DonationRepository;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;


//@Controller
//public class HomeController {
//
//    private final InstitutionService institutionService;
//    private final DonationService donationService;
//
//
//
//    public HomeController(InstitutionService institutionService, DonationService donationService) {
//        this.institutionService = institutionService;
//        this.donationService = donationService;
//
//    }
//
//    @RequestMapping("/")
//    public String homeAction(Model model){
//        model.addAttribute("institutions",institutionService.findAllInstitutions());
//        model.addAttribute("numberOfBags",donationService.sumOfBags());
//        model.addAttribute("numberOfInstitutions", donationService.sumOfDonatedInstitutions());
//        return "index";
//    }
//
//}
