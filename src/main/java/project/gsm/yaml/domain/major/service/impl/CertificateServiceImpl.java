package project.gsm.yaml.domain.major.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.major.entity.Certificate;
import project.gsm.yaml.domain.major.entity.Major;
import project.gsm.yaml.domain.major.exceptions.CertificateNotFoundException;
import project.gsm.yaml.domain.major.presentation.dto.request.CertificateRequest;
import project.gsm.yaml.domain.major.presentation.dto.request.ModifyCertificateRequest;
import project.gsm.yaml.domain.major.presentation.dto.response.CertificateResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.SingleCertificateResponse;
import project.gsm.yaml.domain.major.repository.CertificateRepository;
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
    private final CertificateRepository certificateRepository;

    @Override
    public CertificateResponse getCertificate() {
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

    @Override
    public void postCertificate(CertificateRequest certificateRequest) {
        Certificate certificate = Certificate.builder()
                .name(certificateRequest.getName())
                .fileURL(certificateRequest.getFileURL())
                .build();

        certificateRepository.save(certificate);
    }

    @Override
    public void patchCertificate(Long id, ModifyCertificateRequest modifyCertificateRequest) {
        Certificate certificate = certificateRepository.findById(id).orElseThrow(() -> new CertificateNotFoundException("자격증을 찾을 수 없습니다"));
        certificate.update(modifyCertificateRequest.getName(), modifyCertificateRequest.getFileURL());
    }
}
