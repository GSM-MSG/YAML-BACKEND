package project.gsm.yaml.domain.humanities.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.ChineseLevel;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@RequiredArgsConstructor
public class ModifyChineseCertificateRequest {
    @Enumerated(EnumType.STRING)
    private ChineseLevel level;
    private String fileURL;
}
