package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.repositories.CategoryRepository;
import pl.coderslab.charity.domain.repositories.DonationRepository;
import pl.coderslab.charity.domain.repositories.InstitutionRepository;
import pl.coderslab.charity.dtos.DonationDTO;
import pl.coderslab.charity.services.DonationService;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationService donationService;


    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository, DonationService donationService) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationService = donationService;
    }

    @GetMapping("/form")
    public String prepareDonationProcess (Model model) {
        model.addAttribute("donationDTO",new DonationDTO());
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("institutions", institutionRepository.findAll());
        return "form";
    }
    @PostMapping("/form")
    public  String saveDonation(@ModelAttribute("donationDTO") DonationDTO donationDTO) {
        donationService.makeDonation(donationDTO);
        return "form-confirmation";

    }




}
