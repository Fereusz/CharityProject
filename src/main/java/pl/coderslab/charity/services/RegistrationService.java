package pl.coderslab.charity.services;


import pl.coderslab.charity.dtos.RegistrationDTO;

import java.util.List;

public interface RegistrationService  {

    void register (RegistrationDTO registrationDTO);
    void adminRegister(RegistrationDTO registrationDTO);
    List<RegistrationDTO> findAllAdmins();
    void deleteAdmin (RegistrationDTO registrationDTO, Long id);
    RegistrationDTO updateAdmin (Long id);

            // users//

    List<RegistrationDTO> findAllUsers();
    void deleteUser (RegistrationDTO registrationDTO,Long id);
}
