package project.gsm.yaml.domain.major.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.gsm.yaml.domain.major.presentation.dto.request.*;
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
        MajorClubResponse majorClubResponse = majorClubService.getMajorClub();
        return new ResponseEntity<>(majorClubResponse, HttpStatus.OK);
    }

    @GetMapping("/certificate")
    public ResponseEntity<CertificateResponse> getCertificate() {
        CertificateResponse certificateResponse = certificateService.getCertificate();
        return new ResponseEntity<>(certificateResponse, HttpStatus.OK);
    }
    @GetMapping("/topcit")
    public ResponseEntity<TopcitResponse> getTopcit() {
        TopcitResponse topcitResponse = topcitService.getTopcit();
        return new ResponseEntity<>(topcitResponse, HttpStatus.OK);
    }

    @PostMapping("/outside-prize")
    public ResponseEntity<Void> postOutsidePrize(@RequestBody @Valid OutsidePrizeRequest outsidePrizeRequest) {
        prizeService.postPrize(outsidePrizeRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/outside-contest")
    public ResponseEntity<Void> postOutsideContest(@RequestBody @Valid OutsideContestRequest outsideContestRequest) {
        contestService.postContest(outsideContestRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/certificate")
    public ResponseEntity<Void> postCertificate(@RequestBody @Valid CertificateRequest certificateRequest) {
        certificateService.postCertificate(certificateRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/outside-prize/{id}")
    public ResponseEntity<Void> patchOutsidePrize(@PathVariable Long id, @RequestBody @Valid ModifyOutsidePrizeRequest modifyOutsidePrizeRequest) {
        prizeService.patchOutsidePrize(id, modifyOutsidePrizeRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/inside-prize")
    public ResponseEntity<Void> patchInsidePrize(@RequestBody @Valid ModifyInsidePrizeRequest modifyInsidePrizeRequest) {
        prizeService.patchInsidePrize(modifyInsidePrizeRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/outside-contest/{id}")
    public ResponseEntity<Void> patchOutsideContest(@PathVariable Long id, @RequestBody @Valid ModifyOutsideContestRequest modifyOutsideContestRequest) {
        contestService.patchOutsideContest(id, modifyOutsideContestRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/inside-contest")
    public ResponseEntity<Void> patchInsideContest(@RequestBody @Valid ModifyInsideContestRequest modifyInsideContestRequest) {
        contestService.patchInsideContest(modifyInsideContestRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/major-club")
    public ResponseEntity<Void> patchMajorClub(@RequestBody @Valid ModifyMajorClubRequest modifyMajorClubRequest) {
        majorClubService.patchMajorClub(modifyMajorClubRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/certificate/{id}")
    public ResponseEntity<Void> patchCertificate(@PathVariable Long id, @RequestBody @Valid ModifyCertificateRequest modifyCertificateRequest) {
        certificateService.patchCertificate(id, modifyCertificateRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/topcit")
    public ResponseEntity<Void> patchTopcit(@RequestBody @Valid ModifyTopcitRequest modifyTopcitRequest) {
        topcitService.patchTopcit(modifyTopcitRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
