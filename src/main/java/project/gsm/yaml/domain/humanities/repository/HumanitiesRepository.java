package project.gsm.yaml.domain.humanities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.gsm.yaml.domain.humanities.entity.Humanities;

public interface HumanitiesRepository extends JpaRepository<Humanities, Long> {
}
