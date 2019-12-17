package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.repositories.InstitutionRepository;


@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;

    public HomeController(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        return "index";
    }

    @GetMapping("/")
    public String showInformations (Model model) {
        model.addAttribute("institutions", institutionRepository.findAll());
        return "index";
    }
}
