package project.gsm.yaml.domain.major.service;

import project.gsm.yaml.domain.major.presentation.dto.request.CertificateRequest;
import project.gsm.yaml.domain.major.presentation.dto.response.CertificateResponse;

public interface CertificateService {
    CertificateResponse getCertificate();

    void postCertificate(CertificateRequest certificateRequest);
}
