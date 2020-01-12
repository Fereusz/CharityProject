package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dtos.DonationDTO;
import pl.coderslab.charity.dtos.LoggedUserEditDTO;
import pl.coderslab.charity.dtos.UserDTO;
import pl.coderslab.charity.services.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;


    public UserController(UserService userService, CategoryService categoryService, InstitutionService institutionService, DonationService donationService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping("/edit")
    public String prepareUpdateUser(Model model, Principal principal) {
        model.addAttribute("editUser", userService.updateLoggedUser(principal));
        return "users/user-edit";
    }

    @PostMapping("/edit")
    public String processUpdateUser(@ModelAttribute("editUser") @Valid LoggedUserEditDTO loggedUserEditDTO,
                                    BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "users/user-edit";
        }
        userService.processUpdateLoggedUser(loggedUserEditDTO, principal);
        return "redirect:/";
    }

    @GetMapping("/password")
    public String prepareUpdatePassword(Model model, Principal principal) {
        model.addAttribute("passwordChange", userService.updatePasswordForLoggedUser(principal));
        return "users/password-change";
    }

    @PostMapping("/password")
    public String processUpdatePassword(@Valid UserDTO userDTO, Principal principal, BindingResult result) {
        if (result.hasErrors()) {
            return "users/password-change";
        }
        userService.processUpdatePasswordForLoggedUser(userDTO, principal);
        return "redirect:/";

    }

    //ZARZADZANIE DARAMI//

    @GetMapping("/donations")
    public String prepareUserDonationsPage(Model model, Principal principal) {
        model.addAttribute("allDonations", donationService.getAllDonationsForLoggedUser(principal));
        return "users/donations-all";
    }

    @GetMapping("/donations/delete")
    public String deleteUSerDonation(Long id) {
        donationService.deleteDonationForLoggedUser(id);
        return "redirect:/user/donations";
    }

    @GetMapping("/donations/update")
    public String prepareDonationUpdateForLoggedUser(Long id, Model model) {
        model.addAttribute("donationEdit", donationService.updateDonationForLoggedUser(id));
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("institutions", institutionService.findAllInstitutions());
        return "users/donation-edit";

    }

    @PostMapping("/donations/update")
    public String processDonationUpdateForLoggedUser (@ModelAttribute("donationEdit") @Valid DonationDTO donationDTO
                                                    ,BindingResult result) {
        if (result.hasErrors()){
            return "users/donation-edit";
        }
        donationService.makeDonation(donationDTO);
        return "redirect:/";

    }
}
