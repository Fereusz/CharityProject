package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.repositories.DonationRepository;
import pl.coderslab.charity.domain.repositories.InstitutionRepository;


@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        return "index";
    }

    @GetMapping("/")
    public String showInformationsOnIndexPage (Model model) {
        model.addAttribute("institutions", institutionRepository.findAll());
      model.addAttribute("numberOfBags",donationRepository.sumOfBags());
      model.addAttribute("numberOfInstitutions", donationRepository.sumOfDonatedInstitutions());
        return "index";
    }
}
