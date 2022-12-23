package project.gsm.yaml.domain.major.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.major.entity.Certificate;
import project.gsm.yaml.domain.major.entity.Major;
import project.gsm.yaml.domain.major.presentation.dto.response.CertificateResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.SingleCertificateResponse;
import project.gsm.yaml.domain.major.service.CertificateService;
import project.gsm.yaml.domain.major.utils.MajorCalculateTotalUtil;
import project.gsm.yaml.domain.user.utils.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {

    private final UserUtil userUtil;
    private final MajorCalculateTotalUtil majorCalculateTotalUtil;

    @Override
    public CertificateResponse execute() {
        Major major = userUtil.currentUser().getMajor();
        List<SingleCertificateResponse> singleCertificateResponseList = major.getCertificates().stream()
                .map(SingleCertificateResponse::new)
                .collect(Collectors.toList());
        int total = majorCalculateTotalUtil.calculateCertificate(singleCertificateResponseList.size());

        return CertificateResponse.builder()
                .list(singleCertificateResponseList)
                .total(total)
                .build();
    }
}
