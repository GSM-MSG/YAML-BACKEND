package project.gsm.yaml.domain.humanities.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import project.gsm.yaml.domain.humanities.presentation.dto.response.AwardsResponse;
import project.gsm.yaml.domain.humanities.service.HumanitiesService;

@Controller
@RequestMapping("/humanities")
@RequiredArgsConstructor
public class HumanitiesController {

    private final HumanitiesService humanitiesService;

}
