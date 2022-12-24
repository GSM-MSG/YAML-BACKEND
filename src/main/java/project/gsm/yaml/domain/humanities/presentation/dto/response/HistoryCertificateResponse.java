package project.gsm.yaml.domain.humanities.presentation.dto.response;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.ChineseLevel;
import project.gsm.yaml.domain.humanities.entity.HistoryCertificate;

@RequiredArgsConstructor
public class HistoryCertificateResponse {
    private ChineseLevel level;
    private String fileURL;

    public HistoryCertificateResponse(HistoryCertificate historyCertificate){
        this.level = historyCertificate.getLevel();
        this.fileURL = historyCertificate.getFileURL();
    }
}
