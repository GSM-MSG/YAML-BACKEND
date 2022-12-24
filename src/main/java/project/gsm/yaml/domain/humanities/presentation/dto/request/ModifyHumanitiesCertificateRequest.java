package project.gsm.yaml.domain.humanities.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ModifyHumanitiesCertificateRequest {
    private final ModifyChineseCertificateRequest chinese;
    private final ModifyHistoryCertificateRequest history;
}
