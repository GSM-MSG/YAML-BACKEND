package project.gsm.yaml.domain.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gsm.yaml.domain.major.entity.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
