package project.gsm.yaml.domain.humanities.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.gsm.yaml.domain.humanities.presentation.dto.request.*;
import project.gsm.yaml.domain.humanities.presentation.dto.response.*;
import project.gsm.yaml.domain.humanities.service.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/humanities")
@RequiredArgsConstructor
public class HumanitiesController {

    private final PrizeService prizeService;
    private final BookService bookService;
    private final VolunteerService volunteerService;
    private final HumanitiesCertificateService humanitiesCertificateService;
    private final SportsService sportsService;


    @GetMapping("/prize")
    public ResponseEntity<PrizeResponse> getPrize() {
        PrizeResponse prizeResponse = prizeService.prizeExecute();
        return new ResponseEntity<>(prizeResponse, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<BooksResponse> getBooks(){
        BooksResponse booksResponse = bookService.booksExecute();
        return new ResponseEntity<>(booksResponse, HttpStatus.OK);
    }

    @GetMapping("/volunteer")
    public ResponseEntity<VolunteersResponse> getVolunteers(){
        VolunteersResponse volunteersResponse = volunteerService.volunteersExecute();
        return new ResponseEntity<>(volunteersResponse, HttpStatus.OK);
    }

    @GetMapping("/certificate")
    public ResponseEntity<HumanitiesCertificateResponse> getHumanitiesCertificate(){
        HumanitiesCertificateResponse humanitiesCertificateResponse = humanitiesCertificateService.humanitiesCertificateExecute();
        return new ResponseEntity<>(humanitiesCertificateResponse, HttpStatus.OK);
    }

    @GetMapping("/sports")
    public ResponseEntity<SportsResponse> getSports(){
        SportsResponse sportsResponse = sportsService.sportsExecute();
        return new ResponseEntity<>(sportsResponse, HttpStatus.OK);
    }

    @PostMapping("/prize")
    public ResponseEntity<Void> postPrize(@RequestBody @Valid PrizeRequest prizeRequest){
        prizeService.postPrizeExecute(prizeRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/books")
    public ResponseEntity<Void> postBooks(@RequestBody @Valid BooksRequest booksRequest){
        bookService.postBooksExecute(booksRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/volunteer")
    public ResponseEntity<Void> postVolunteers(@RequestBody @Valid VolunteerRequest volunteerRequest){
        volunteerService.postVolunteersExecute(volunteerRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/prize/{id}")
    public ResponseEntity<Void> patchPrize(@PathVariable Long id, @RequestBody @Valid ModifyPrizeRequest modifyPrizeRequest){
        prizeService.patchPrizeExecute(id, modifyPrizeRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/books/{id}")
    public ResponseEntity<Void> patchbooks(@PathVariable Long id, @RequestBody @Valid ModifyBooksRequest modifyBooksRequest){
        bookService.patchBooksExecute(id, modifyBooksRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/books/marathon")
    public ResponseEntity<Void> patchBooksMarathon(@RequestBody @Valid ModifyBookMarathonRequest modifyBookMarathonRequest){
        bookService.patchBooksMarathonExecute(modifyBookMarathonRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/volunteer/{id}")
    public ResponseEntity<Void> patchVolunteer(@PathVariable Long id, @RequestBody @Valid ModifyVolunteerRequest modifyVolunteerRequest){
        volunteerService.patchVolunteerExecute(id, modifyVolunteerRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/certificate")
    public ResponseEntity<Void> patchCertificate(@RequestBody @Valid ModifyHumanitiesCertificateRequest modifyHumanitiesCertificateRequest){
        humanitiesCertificateService.patchCertificateExecute(modifyHumanitiesCertificateRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/sports")
    public ResponseEntity<Void> patchSports(@RequestBody @Valid ModifySportsRequest modifySportsRequest){
        sportsService.patchSportsExecute(modifySportsRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/prize/{id}")
    public ResponseEntity<Void> deletePrize(@PathVariable Long id){
        prizeService.deletePrizeExecute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBooks(@PathVariable Long id){
        bookService.deleteBooksExecute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/volunteer/{id}")
    public ResponseEntity<Void> deleteVolunteer(@PathVariable Long id){
        volunteerService.deleteVolunteerExecute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/chinese-certificate")
    public ResponseEntity<Void> deleteChineseCertificate(@PathVariable Long id){
        humanitiesCertificateService.deleteChineseCertificate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/history-certificate")
    public ResponseEntity<Void> deleteHistoryCertificate(@PathVariable Long id){
        humanitiesCertificateService.deletehistoryCertificate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
