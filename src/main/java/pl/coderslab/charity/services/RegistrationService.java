package pl.coderslab.charity.services;


import pl.coderslab.charity.dtos.RegistrationDTO;

import java.util.List;

public interface RegistrationService  {

                //ADMIN//

    void register (RegistrationDTO registrationDTO);
    void adminRegister(RegistrationDTO registrationDTO);
    List<RegistrationDTO> findAllAdmins();
    void deleteAdmin (RegistrationDTO registrationDTO, Long id);
    RegistrationDTO updateAdmin (Long id);

                // USERS//

    List<RegistrationDTO> findAllUsers();
    void deleteUser (RegistrationDTO registrationDTO,Long id);
    RegistrationDTO updateUser (Long id);

}
