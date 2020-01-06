package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dtos.RegistrationDTO;
import pl.coderslab.charity.services.RegistrationService;
import pl.coderslab.charity.services.UserService;

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
        model.addAttribute("editUser",userService.updateUser(principal));
        return "users/user-edit";
    }

    // ??? /// Jak zapisać zmiany ??
    @PostMapping("/edit")
    public String processUpdateUser (@ModelAttribute("editUser") @Valid RegistrationDTO registrationDTO,
                                     BindingResult result) {
        if(result.hasErrors()){
            return "users/user-edit";
        }
        registrationService.register(registrationDTO);
        return "/user";
    }

}
