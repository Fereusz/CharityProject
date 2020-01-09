package pl.coderslab.charity.services;

import pl.coderslab.charity.dtos.LoggedUserEditDTO;
import pl.coderslab.charity.dtos.RegistrationDTO;
import pl.coderslab.charity.dtos.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

public interface UserService {

    UserDTO updateLoggedUser(Principal principal);
    void processUpdateLoggedUser(LoggedUserEditDTO loggedUserEditDTO, Principal principal);

    void register (UserDTO userDTO);

    List<UserDTO> findAllUsers();

    void deleteUser (UserDTO userDTO,Long id);
    UserDTO updateUser (Long id);

    void blockUserById(Long id);
    void unblockUserById(Long id);

}
