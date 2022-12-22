package project.gsm.yaml.domain.major.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gsm.yaml.domain.major.presentation.dto.response.PrizeResponse;
import project.gsm.yaml.domain.major.presentation.service.PrizeService;

@RestController
@RequestMapping("/major")
@RequiredArgsConstructor
public class MajorController {
    private final PrizeService prizeService;

    @GetMapping("/prize")
    public ResponseEntity<PrizeResponse> getPrize() {
        PrizeResponse prizeResponse = prizeService.execute();
        return new ResponseEntity<>(prizeResponse, HttpStatus.OK);
    }

}
