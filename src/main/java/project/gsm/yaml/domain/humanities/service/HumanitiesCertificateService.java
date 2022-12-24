package project.gsm.yaml.domain.humanities.service;

import project.gsm.yaml.domain.humanities.presentation.dto.request.ModifyHumanitiesCertificateRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.response.HumanitiesCertificateResponse;

public interface HumanitiesCertificateService {
    HumanitiesCertificateResponse humanitiesCertificateExecute();

    void patchCertificateExecute(ModifyHumanitiesCertificateRequest modifyHumanitiesCertificateRequest);

    void deleteChineseCertificate(Long id);
}
