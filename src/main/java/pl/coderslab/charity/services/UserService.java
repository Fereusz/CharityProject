package pl.coderslab.charity.services;

import pl.coderslab.charity.dtos.RegistrationDTO;

import java.security.Principal;

public interface UserService {

    RegistrationDTO updateUser(Principal principal);

}
