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
import pl.coderslab.charity.dtos.InstitutionDTO;
import pl.coderslab.charity.dtos.RegistrationDTO;
import pl.coderslab.charity.dtos.UserDTO;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;
import pl.coderslab.charity.services.RegistrationService;
import pl.coderslab.charity.services.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final RegistrationService registrationService;
    private final UserRepository userRepository;
    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final UserService userService;

    public AdminController(RegistrationService registrationService, UserRepository userRepository, InstitutionService institutionService, DonationService donationService, UserService userService) {
        this.registrationService = registrationService;
        this.userRepository = userRepository;
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userService = userService;
    }

                             // ADMIN MANAGEMENT//

    @GetMapping
    public String getAdminPage(Principal principal, Model model) {
        String name = principal.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("admin", user);
        model.addAttribute("institutions", institutionService.findAllInstitutions());
        model.addAttribute("numberOfBags", donationService.sumOfBags());
        model.addAttribute("numberOfInstitutions", donationService.sumOfDonatedInstitutions());
        return "admin/admin-main";

    }

    @GetMapping("/admins")
    public String allAdminsPage(Model model) {
        model.addAttribute("allAdmins", registrationService.findAllAdmins());
        return "admin/admin-all";
    }

    @GetMapping("/create")
    public String prepareAdminAccount(Model model) {
        model.addAttribute("registerAdmin", new RegistrationDTO());
        return "admin/admin-add";
    }

    @PostMapping("/create")
    public String processAdminAccount(@ModelAttribute("registerAdmin") @Valid RegistrationDTO registrationDTO,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "admin/admin-add";
        }
        registrationService.adminRegister(registrationDTO);
        return "redirect:/";
    }

    @GetMapping("admins/delete")
    public String deleteAdminAccount(RegistrationDTO registrationDTO, Long id) {
        registrationService.deleteAdmin(registrationDTO, id);
        return "redirect:/admin/admins";
    }

    @GetMapping("admins/edit")
    public String prepareUpdateAdminAccount(Model model, Long id) {
        model.addAttribute("adminUpdate", registrationService.updateAdmin(id));
        return "/admin/admin-update";
    }

    @PostMapping("admins/edit")
    public String processUpdateAdminAccount(@ModelAttribute("adminUpdate") @Valid RegistrationDTO registrationDTO,
                                            BindingResult result) {
        if (result.hasErrors()) {
            return "admins/update-admin";
        }
        registrationService.adminRegister(registrationDTO);
        return "redirect:/admin/admins";
    }

                                 // INSTITUTIONS MANAGEMENT //


    @GetMapping("/institutions")
    public String showAllInstitutions(Model model) {
        model.addAttribute("allInstitutions", institutionService.findAllInstitutions());
        return "admin/institution-all";
    }


   @GetMapping("/institutions/delete")
    public String deleteInstitution(InstitutionDTO institutionDTO, Long id) {
        institutionService.deleteInstitution(institutionDTO,id);
        return "redirect:/admin/institutions";

    }

    @GetMapping("/institution/add")
    public String prepareAddNewInstitution(Model model) {
        model.addAttribute("institutionAdd", new InstitutionDTO());
        return "admin/institution-add";

    }

    @PostMapping("/institution/add")
    public String processAddNewInstitution(@ModelAttribute("institutionAdd") @Valid InstitutionDTO institutionDTO,
                                           BindingResult result) {
        if (result.hasErrors()) {
            return "admin/institution-add";
        }
        institutionService.addInstitution(institutionDTO);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/institutions/edit")
    public String prepareUpdateInstitution(Model model, Long id) {
        model.addAttribute("updateInstitution", institutionService.prepareUpdate(id));
        return "admin/institution-update";

    }

    @PostMapping("/institutions/edit")
    public String processUpdateInstitution (@ModelAttribute ("updateInstitution") @Valid InstitutionDTO
                                                    institutionDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/institution-update";
        }
        institutionService.addInstitution(institutionDTO);
        return "redirect:/admin/institutions";
    }

                //USER MANAGEMENT//

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers",userService.findAllUsers());
        return "users/users-all";
    }

    @GetMapping("/users/delete")
    public String deleteUser (UserDTO userDTO, Long id) {
        userService.deleteUser(userDTO,id);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/edit")
    public String prepareUpdateUserAccount (Model model, Long id) {
        model.addAttribute("userUpdate",userService.updateUser(id));
        return "users/user-update";
    }

    @PostMapping("/users/edit")
    public String processUpdateUserAccount (@ModelAttribute("userUpdate") @Valid UserDTO userDTO,
                                            BindingResult result){
        if(result.hasErrors()){
            return "users/user-update";
        }
        userService.register(userDTO);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/block")
    public String blockUser (Long id) {
        userService.blockUserById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/unblock")
    public String unblockUser (Long id) {
        userService.unblockUserById(id);
        return "redirect:/admin/users";
    }
}



