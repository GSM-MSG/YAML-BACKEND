package project.gsm.yaml.domain.humanities.presentation.dto.response;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.ChineseLevel;

@RequiredArgsConstructor
public class HistoryCertificateResponse {
    private ChineseLevel level;
    private String fileURL;
}
