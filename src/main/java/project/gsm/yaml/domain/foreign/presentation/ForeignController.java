package project.gsm.yaml.domain.foreign.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gsm.yaml.domain.foreign.presentation.request.ModifyForeignRequest;
import project.gsm.yaml.domain.foreign.service.ForeignService;
import project.gsm.yaml.domain.humanities.presentation.dto.request.ModifySportsRequest;

@RestController
@RequestMapping("/foreign")
@RequiredArgsConstructor
public class ForeignController {
    private final ForeignService foreignService;

    @PatchMapping("/")
    public ResponseEntity<Void> patchForeign(ModifyForeignRequest modifyForeignRequest){
        foreignService
    }
}
