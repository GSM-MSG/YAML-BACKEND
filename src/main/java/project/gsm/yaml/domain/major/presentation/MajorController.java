package project.gsm.yaml.domain.major.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gsm.yaml.domain.major.presentation.dto.response.CertificateResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.ContestResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.MajorClubResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.PrizeResponse;
import project.gsm.yaml.domain.major.service.CertificateService;
import project.gsm.yaml.domain.major.service.ContestService;
import project.gsm.yaml.domain.major.service.MajorClubService;
import project.gsm.yaml.domain.major.service.PrizeService;

@RestController
@RequestMapping("/major")
@RequiredArgsConstructor
public class MajorController {
    private final PrizeService prizeService;
    private final ContestService contestService;
    private final MajorClubService majorClubService;
    private final CertificateService certificateService;

    @GetMapping("/prize")
    public ResponseEntity<PrizeResponse> getPrize() {
        PrizeResponse prizeResponse = prizeService.execute();
        return new ResponseEntity<>(prizeResponse, HttpStatus.OK);
    }

    @GetMapping("/contest")
    public ResponseEntity<ContestResponse> getContest() {
        ContestResponse contestResponse = contestService.execute();
        return new ResponseEntity<>(contestResponse, HttpStatus.OK);
    }

    @GetMapping("major-club")
    public ResponseEntity<MajorClubResponse> getMajorClub() {
        MajorClubResponse majorClubResponse = majorClubService.execute();
        return new ResponseEntity<>(majorClubResponse, HttpStatus.OK);
    }

    @GetMapping("certificate")
    private ResponseEntity<CertificateResponse> getCertificate() {
        CertificateResponse certificateResponse = certificateService.execute();
        return new ResponseEntity<>(certificateResponse, HttpStatus.OK);
    }
}
