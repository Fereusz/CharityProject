package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dtos.DonationDTO;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;

import javax.validation.Valid;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;


    public DonationController(CategoryService categoryService, InstitutionService institutionService, DonationService donationService) {
        this.categoryService= categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping("/form")
    public String prepareDonationProcess (Model model) {
        model.addAttribute("donationDTO",new DonationDTO());
        model.addAttribute("categories",categoryService.findAllCategories());
        model.addAttribute("institutions", institutionService.findAllInstitutions());
        return "form";
    }
    @PostMapping("/form")
    public  String saveDonation(@ModelAttribute("donationDTO") @Valid DonationDTO donationDTO, BindingResult result) {
        if(result.hasErrors()){
            return "form";
        }
        donationService.makeDonation(donationDTO);
        return "form-confirmation";

    }




}
