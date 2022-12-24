package project.gsm.yaml.domain.humanities.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.humanities.entity.Humanities;
import project.gsm.yaml.domain.humanities.presentation.dto.request.ModifyHumanitiesCertificateRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.response.ChineseCertificateResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.HistoryCertificateResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.HumanitiesCertificateResponse;
import project.gsm.yaml.domain.humanities.service.HumanitiesCertificateService;
import project.gsm.yaml.domain.humanities.utils.HumanitiesCaculateTotalUtil;
import project.gsm.yaml.domain.user.utils.UserUtil;

@RequiredArgsConstructor
@Service
public class HumanitiesCertificateServiceImpl implements HumanitiesCertificateService {
    private final UserUtil userUtil;
    private final HumanitiesCaculateTotalUtil caculateTotalUtil;

    @Override
    public HumanitiesCertificateResponse humanitiesCertificateExecute(){
        Humanities user = userUtil.currentUser().getHumanities();
        ChineseCertificateResponse chineseCertificate = new ChineseCertificateResponse(user.getChineseCertificate());
        HistoryCertificateResponse historyCertificate = new HistoryCertificateResponse(user.getHistoryCertificates());
        int chinese = user.getChineseCertificate().getLevel().getScore();
        int history = user.getHistoryCertificates().getLevel().getScore();
        int total = caculateTotalUtil.calculateHumanitiesCertificate(chinese, history);
        return HumanitiesCertificateResponse.builder()
                .chinese(chineseCertificate)
                .history(historyCertificate)
                .total(total)
                .build();
    }

    @Override
    public void patchCertificateExecute(ModifyHumanitiesCertificateRequest modifyHumanitiesCertificateRequest) {
        Humanities humanities = userUtil.currentUser().getHumanities();
        humanities.getChineseCertificate().update(modifyHumanitiesCertificateRequest.getChinese().getLevel(), modifyHumanitiesCertificateRequest.getChinese().getFileURL());
        humanities.getHistoryCertificates().update(modifyHumanitiesCertificateRequest.getHistory().getLevel(), modifyHumanitiesCertificateRequest.getHistory().getFileURL());
    }
}
