package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.major.entity.Certificate;

import java.util.List;

@Builder
@RequiredArgsConstructor
public class CertificateResponse {

    private final List<SingleCertificateResponse> list;

    private final Integer total;
}
