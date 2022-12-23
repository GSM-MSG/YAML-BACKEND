package project.gsm.yaml.domain.humanities.presentation.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.ChineseCharacter;

import java.util.logging.Level;

@RequiredArgsConstructor
@Builder
public class ChineseCertificatesResponse {
    private ChineseCharacter chineseCharacter;
    private String fileURL;
    private Integer total;
}
