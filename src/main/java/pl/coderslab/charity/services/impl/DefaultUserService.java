package pl.coderslab.charity.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.domain.repositories.UserRepository;
import pl.coderslab.charity.dtos.RegistrationDTO;
import pl.coderslab.charity.services.UserService;

import java.security.Principal;

@Service
@Transactional
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public RegistrationDTO updateUser(Principal principal) {
        ModelMapper mapper = new ModelMapper();
        User userToEdit = userRepository.findByUsername(principal.getName());
        return mapper.map(userToEdit, RegistrationDTO.class);

    }




}
