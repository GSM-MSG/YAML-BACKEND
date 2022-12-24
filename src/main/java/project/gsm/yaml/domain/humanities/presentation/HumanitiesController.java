package project.gsm.yaml.domain.humanities.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gsm.yaml.domain.humanities.presentation.dto.response.*;
import project.gsm.yaml.domain.humanities.service.HumanitiesService;

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
    public ResponseEntity<HumanitiesCertificateResponse> getChineseCertificate(){
        HumanitiesCertificateResponse humanitiesCertificateResponse = humanitiesService.chineseCertificateExecute();
        return new ResponseEntity<>(humanitiesCertificateResponse, HttpStatus.OK);
    }

    @GetMapping("/sports")
    public ResponseEntity<>

}
