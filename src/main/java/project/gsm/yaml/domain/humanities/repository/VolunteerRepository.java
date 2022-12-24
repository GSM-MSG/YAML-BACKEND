package project.gsm.yaml.domain.humanities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gsm.yaml.domain.humanities.entity.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}
