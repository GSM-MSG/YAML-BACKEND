package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.major.entity.Certificate;

@RequiredArgsConstructor
public class SingleCertificateResponse {
    private final Long id;
    private final String name;
    private final String fileURL;

    public SingleCertificateResponse(Certificate certificate) {
        this.id = certificate.getId();
        this.name = certificate.getName();
        this.fileURL = certificate.getFileURL();
    }
}
