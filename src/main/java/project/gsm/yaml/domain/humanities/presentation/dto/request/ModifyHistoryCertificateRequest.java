package project.gsm.yaml.domain.humanities.presentation.dto.request;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.HistoryLevel;

@RequiredArgsConstructor
public class ModifyHistoryCertificateRequest {
    private HistoryLevel level;
    private String fileURL;
}
