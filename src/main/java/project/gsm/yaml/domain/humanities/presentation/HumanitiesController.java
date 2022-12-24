package project.gsm.yaml.domain.humanities.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.gsm.yaml.domain.humanities.presentation.dto.response.*;
import project.gsm.yaml.domain.humanities.service.HumanitiesService;

import javax.validation.Valid;

@RestController
@RequestMapping("/humanities")
@RequiredArgsConstructor
public class HumanitiesController {

    private final HumanitiesService humanitiesService;

    @GetMapping("/prize")
    public ResponseEntity<PrizeResponse> getPrize() {
        PrizeResponse prizeResponse = humanitiesService.prizeExecute();
        return new ResponseEntity<>(prizeResponse, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<BooksResponse> getBooks(){
        BooksResponse booksResponse = humanitiesService.booksExecute();
        return new ResponseEntity<>(booksResponse, HttpStatus.OK);
    }

    @GetMapping("/volunteer")
    public ResponseEntity<VolunteersResponse> getVolunteers(){
        VolunteersResponse volunteersResponse = humanitiesService.volunteersExecute();
        return new ResponseEntity<>(volunteersResponse, HttpStatus.OK);
    }

    @GetMapping("/certificate")
    public ResponseEntity<HumanitiesCertificateResponse> getHumanitiesCertificate(){
        HumanitiesCertificateResponse humanitiesCertificateResponse = humanitiesService.humanitiesCertificateExecute();
        return new ResponseEntity<>(humanitiesCertificateResponse, HttpStatus.OK);
    }

    @GetMapping("/sports")
    public ResponseEntity<SportsResponse> getSports(){
        SportsResponse sportsResponse = humanitiesService.sportsExecute();
        return new ResponseEntity<>(sportsResponse, HttpStatus.OK);
    }

    @PostMapping("/prize")
    public ResponseEntity<Void> postPrize(@RequestBody @Valid ){
        humanitiesService.
    }

}
