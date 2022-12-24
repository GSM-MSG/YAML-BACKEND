package project.gsm.yaml.domain.major.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.gsm.yaml.domain.major.presentation.dto.request.OutsidePrizeRequest;
import project.gsm.yaml.domain.major.presentation.dto.response.*;
import project.gsm.yaml.domain.major.service.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/major")
@RequiredArgsConstructor
public class MajorController {
    private final PrizeService prizeService;
    private final ContestService contestService;
    private final MajorClubService majorClubService;
    private final CertificateService certificateService;
    private final TopcitService topcitService;

    @GetMapping("/prize")
    public ResponseEntity<PrizeResponse> getPrize() {
        PrizeResponse prizeResponse = prizeService.getPrize();
        return new ResponseEntity<>(prizeResponse, HttpStatus.OK);
    }

    @GetMapping("/contest")
    public ResponseEntity<ContestResponse> getContest() {
        ContestResponse contestResponse = contestService.getContest();
        return new ResponseEntity<>(contestResponse, HttpStatus.OK);
    }

    @GetMapping("/major-club")
    public ResponseEntity<MajorClubResponse> getMajorClub() {
        MajorClubResponse majorClubResponse = majorClubService.execute();
        return new ResponseEntity<>(majorClubResponse, HttpStatus.OK);
    }

    @GetMapping("/certificate")
    public ResponseEntity<CertificateResponse> getCertificate() {
        CertificateResponse certificateResponse = certificateService.execute();
        return new ResponseEntity<>(certificateResponse, HttpStatus.OK);
    }
    @GetMapping("/topcit")
    public ResponseEntity<TopcitResponse> getTopcit() {
        TopcitResponse topcitResponse = topcitService.execute();
        return new ResponseEntity<>(topcitResponse, HttpStatus.OK);
    }

    @PostMapping("/outside-prize")
    public ResponseEntity<Void> postOutSidePrize(@RequestBody @Valid OutsidePrizeRequest outsidePrizeRequest) {
        prizeService.postPrize(outsidePrizeRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
