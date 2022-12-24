package project.gsm.yaml.domain.humanities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.gsm.yaml.domain.humanities.entity.HistoryCertificate;

public interface HistoryCertificateRepository extends JpaRepository<HistoryCertificate, Long> {
}
