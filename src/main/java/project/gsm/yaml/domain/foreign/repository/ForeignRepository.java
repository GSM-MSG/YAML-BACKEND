package project.gsm.yaml.domain.foreign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gsm.yaml.domain.foreign.entity.Foreign;

public interface ForeignRepository extends JpaRepository<Foreign, Long> {
}
