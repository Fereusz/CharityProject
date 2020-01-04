package pl.coderslab.charity.services;


import pl.coderslab.charity.dtos.RegistrationDTO;

import java.util.List;

public interface RegistrationService  {

    void register (RegistrationDTO registrationDTO);
    void adminRegister(RegistrationDTO registrationDTO);
    List<RegistrationDTO> findAllAdmins();
}
