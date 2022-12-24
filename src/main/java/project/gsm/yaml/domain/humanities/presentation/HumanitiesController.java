package project.gsm.yaml.domain.humanities.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.gsm.yaml.domain.humanities.presentation.dto.request.BooksRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.request.PrizeRequest;
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
    private HumanitiesCertificateService humanitiesCertificateService;
    private SportsService sportsService;


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
        humanitiesService.postPrizeExecute(prizeRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/books")
    public ResponseEntity<Void> postBooks(@RequestBody @Valid BooksRequest booksRequest){
        humanitiesService.
    }

}
