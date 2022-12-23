package project.gsm.yaml.domain.humanities.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gsm.yaml.domain.humanities.presentation.dto.response.PrizeResponse;
import project.gsm.yaml.domain.humanities.service.PrizeService;

@RestController
@RequestMapping("/humanities")
@RequiredArgsConstructor
public class HumanitiesController {

    private final PrizeService humanitiesService;

    @GetMapping("/prize")
    public ResponseEntity<PrizeResponse> getPrize(@RequestHeader("Authorization") String accessToken) {
        PrizeResponse prizeResponse = humanitiesService.execute(accessToken);
        return new ResponseEntity<>(prizeResponse, HttpStatus.OK);
    }

}