package project.gsm.yaml.domain.humanities.presentation.dto.request;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.ChineseLevel;

@RequiredArgsConstructor
public class ModifyChineseCertificateRequest {
    private ChineseLevel level;
    private String fileURL;
}
