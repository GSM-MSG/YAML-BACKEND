package project.gsm.yaml.domain.humanities.presentation.dto.response;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.ChineseCertificate;
import project.gsm.yaml.domain.humanities.entity.ChineseLevel;

@RequiredArgsConstructor
public class ChineseCertificateResponse {
    private ChineseLevel level;
    private String fileURL;

    public ChineseCertificateResponse (ChineseCertificate chineseCertificate){
        this.level = chineseCertificate.getLevel();
        this.fileURL = chineseCertificate.getFileURL();
    }
}
