package pl.coderslab.charity.services;

import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.dtos.LoggedUserEditDTO;
import pl.coderslab.charity.dtos.RegistrationDTO;
import pl.coderslab.charity.dtos.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

public interface UserService {

                    //logged user
    UserDTO updateLoggedUser(Principal principal);
    void processUpdateLoggedUser(LoggedUserEditDTO loggedUserEditDTO, Principal principal);
    UserDTO updatePasswordForLoggedUser(Principal principal);
    void processUpdatePasswordForLoggedUser(UserDTO userDTO,Principal principal);

                    //Admnin Tools
    void register (UserDTO userDTO);
    List<UserDTO> findAllUsers();
    void deleteUser (UserDTO userDTO,Long id);
    UserDTO updateUser (Long id);
    void blockUserById(Long id);
    void unblockUserById(Long id);

    User findUserByUsername(String username);

}
