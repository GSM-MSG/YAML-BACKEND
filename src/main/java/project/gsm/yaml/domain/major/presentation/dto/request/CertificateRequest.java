package project.gsm.yaml.domain.major.presentation.dto.request;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class CertificateRequest {
    private final String name;

    private final String fileURL;
}
