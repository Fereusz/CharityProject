package pl.coderslab.charity.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Role;
import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.domain.repositories.RoleRepository;
import pl.coderslab.charity.domain.repositories.UserRepository;
import pl.coderslab.charity.dtos.RegistrationDTO;
import pl.coderslab.charity.services.RegistrationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class DefaultRegistrationService implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DefaultRegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void register(RegistrationDTO registrationDTO) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(registrationDTO, User.class);
        user.setActive(Boolean.TRUE);
        String passwordEncoded = passwordEncoder.encode(registrationDTO.getPassword());
        user.setPassword(passwordEncoded);
        Role roleUser = roleRepository.getByName("ROLE_USER");
        user.getRoles().add(roleUser);
        userRepository.save(user);


    }

    @Override
    public void adminRegister(RegistrationDTO registrationDTO) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(registrationDTO, User.class);
        user.setActive(Boolean.TRUE);
        String passwordEncoded = passwordEncoder.encode(registrationDTO.getPassword());
        user.setPassword(passwordEncoded);
        Role role = roleRepository.getByName("ROLE_ADMIN");
        user.getRoles().add(role);
        userRepository.save(user);

    }

    @Override
    public List<RegistrationDTO> findAllAdmins() {
        ModelMapper adminMapper = new ModelMapper();
        return userRepository.allAdmins().stream()
                .map(a -> adminMapper.map(a, RegistrationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAdmin(RegistrationDTO registrationDTO, Long id) {
        User admin = userRepository.findById(id).get();
        if (admin != null) {
            userRepository.delete(admin);
        }

    }

    @Override
    public RegistrationDTO updateAdmin(Long id) {
        ModelMapper mapper = new ModelMapper();
        User adminToEdit = userRepository.findById(id).get();
        return mapper.map(adminToEdit, RegistrationDTO.class);
    }

    //USERS//
    @Override
    public List<RegistrationDTO> findAllUsers() {
        ModelMapper mapper = new ModelMapper();
        return userRepository.allUsers().stream()
                .map(u -> mapper.map(u, RegistrationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(RegistrationDTO registrationDTO, Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    @Override
    public RegistrationDTO updateUser(Long id) {
        ModelMapper mapper = new ModelMapper();
        User userToEdit = userRepository.findById(id).get();
        return mapper.map(userToEdit, RegistrationDTO.class);

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
