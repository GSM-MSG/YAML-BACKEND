package project.gsm.yaml.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.gsm.yaml.entity.Major;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {
}
