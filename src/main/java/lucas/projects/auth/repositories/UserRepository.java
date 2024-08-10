package lucas.projects.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import lucas.projects.auth.domain.user.User;


public interface UserRepository extends JpaRepository<User, String>{
    UserDetails findByLogin(String login);
}
