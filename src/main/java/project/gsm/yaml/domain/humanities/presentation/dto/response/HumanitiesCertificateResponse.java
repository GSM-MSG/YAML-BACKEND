package project.gsm.yaml.domain.humanities.presentation.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Builder
public class HumanitiesCertificateResponse {
    private final List<ChineseCertificateResponse> chinese;
    private final List<HistoryCertificateResponse> history;
    private Integer total;
}
