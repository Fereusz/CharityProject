package pl.coderslab.charity.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.domain.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query(value ="select *from users JOIN users_roles ON users.id = users_roles.user_id WHERE users_roles.roles_id =2", nativeQuery = true)
    List<User> findAllAdmins();


}

