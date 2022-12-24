package project.gsm.yaml.domain.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gsm.yaml.domain.major.entity.OutsideContest;

public interface OutsideContestRepository extends JpaRepository<OutsideContest, Long> {
}
