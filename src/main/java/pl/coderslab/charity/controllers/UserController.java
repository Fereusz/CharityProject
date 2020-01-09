package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dtos.LoggedUserEditDTO;
import pl.coderslab.charity.dtos.RegistrationDTO;
import pl.coderslab.charity.dtos.UserDTO;
import pl.coderslab.charity.services.RegistrationService;
import pl.coderslab.charity.services.UserService;

import javax.naming.ldap.PagedResultsControl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private  final RegistrationService registrationService;


    public UserController(UserService userService, RegistrationService registrationService) {
        this.userService = userService;
        this.registrationService = registrationService;
    }

    @GetMapping("/edit")
    public String prepareUpdateUser (Model model, Principal principal){
        model.addAttribute("editUser",userService.updateLoggedUser(principal));
        return "users/user-edit";
    }

    @PostMapping("/edit")
    public String processUpdateUser (@ModelAttribute("editUser") @Valid LoggedUserEditDTO loggedUserEditDTO,
                                     BindingResult result, Principal principal) {
        if(result.hasErrors()){
            return "users/user-edit";
        }
        userService.processUpdateLoggedUser(loggedUserEditDTO, principal);
        return "redirect:/";
    }
    @GetMapping("/password")
    public String prepareUpdatePassword(Model model, Principal principal) {
        model.addAttribute("passwordChange",userService.updatePasswordForLoggedUser(principal));
        return "users/password-change";
    }

    @PostMapping("/password")
    public String processUpdatePassword (@Valid UserDTO userDTO, Principal principal, BindingResult result) {
        if (result.hasErrors()){
            return "users/password-change";
        }
        userService.processUpdatePasswordForLoggedUser(userDTO,principal);
        return "redirect:/";

    }

}
