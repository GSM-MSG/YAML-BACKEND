package project.gsm.yaml.domain.humanities.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.HistoryLevel;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@RequiredArgsConstructor
public class ModifyHistoryCertificateRequest {
    @Enumerated(EnumType.STRING)
    private HistoryLevel level;
    private String fileURL;
}
