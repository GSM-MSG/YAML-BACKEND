package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.major.entity.Certificate;

import java.util.List;

@RequiredArgsConstructor
public class CertificateResponse {

    private final List<SingleCertificateResponse> list;

    private final Integer total;
}
