package project.gsm.yaml.domain.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gsm.yaml.domain.major.entity.OutsideAwards;

import java.util.Optional;

public interface OutSideAwardsRepository extends JpaRepository<OutsideAwards, Long> {
    Optional<OutsideAwards> findById(Long id);
}
