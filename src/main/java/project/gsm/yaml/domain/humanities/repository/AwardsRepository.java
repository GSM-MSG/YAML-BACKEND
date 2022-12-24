package project.gsm.yaml.domain.humanities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.gsm.yaml.domain.humanities.entity.Awards;

import java.util.Optional;

public interface AwardsRepository extends JpaRepository<Awards, Long> {

}
