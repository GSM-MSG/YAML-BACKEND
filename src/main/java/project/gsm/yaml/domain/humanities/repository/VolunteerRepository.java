package project.gsm.yaml.domain.humanities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gsm.yaml.domain.humanities.entity.Volunteer;

import java.util.Optional;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
    Optional<Volunteer> findById(Long id);
}
