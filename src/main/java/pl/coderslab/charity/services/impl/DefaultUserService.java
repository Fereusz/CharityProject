package pl.coderslab.charity.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Role;
import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.domain.repositories.RoleRepository;
import pl.coderslab.charity.domain.repositories.UserRepository;
import pl.coderslab.charity.dtos.UserDTO;
import pl.coderslab.charity.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public DefaultUserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }


    @Override
    public UserDTO updateUser(Principal principal) {
        ModelMapper mapper = new ModelMapper();
        User userToEdit = userRepository.findByUsername(principal.getName());
        return mapper.map(userToEdit, UserDTO.class);

    }

    @Override
    public void register(UserDTO userDTO) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDTO, User.class);
        user.setActive(Boolean.TRUE);
        String passwordEncoded = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(passwordEncoded);
        Role roleUser = roleRepository.getByName("ROLE_USER");
        user.getRoles().add(roleUser);
        userRepository.save(user);


    }

    @Override
    public List<UserDTO> findAllUsers() {
        ModelMapper mapper = new ModelMapper();
        return userRepository.allUsers().stream()
                .map(u -> mapper.map(u, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(UserDTO userDTO, Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    @Override
    public UserDTO updateUser(Long id) {
        ModelMapper mapper = new ModelMapper();
        User userToEdit = userRepository.findById(id).get();
        return mapper.map(userToEdit, UserDTO.class);

    }

    @Override
    public void blockUserById(Long id) {
        userRepository.blockById(id);

    }

    @Override
    public void unblockUserById(Long id) {
        userRepository.unblockById(id);
    }


}





