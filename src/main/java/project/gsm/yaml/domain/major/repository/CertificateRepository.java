package project.gsm.yaml.domain.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gsm.yaml.domain.major.entity.Certificate;

import java.util.Optional;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    Optional<Certificate> findById (Long id);
}
