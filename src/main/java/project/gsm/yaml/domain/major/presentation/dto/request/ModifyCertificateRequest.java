package project.gsm.yaml.domain.major.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ModifyCertificateRequest {

    private final String name;

    private final String fileURL;
}
