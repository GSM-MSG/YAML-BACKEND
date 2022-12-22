package project.gsm.yaml.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gsm.yaml.domain.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByEmail(String email);
}
