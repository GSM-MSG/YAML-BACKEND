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

    @PostMapping("/prize/{id}")
    public ResponseEntity<Void> patchPrize(@PathVariable Long id, @RequestBody @Valid ModifyPrizeRequest modifyPrizeRequest){
        prizeService.patchPrizeExecute(id, modifyPrizeRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/books/{id}")
    public ResponseEntity<Void> patchbooks(@PathVariable Long id, @RequestBody @Valid ModifyBooksRequest modifyBooksRequest){
        bookService.patchBooksExecute(id, modifyBooksRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
