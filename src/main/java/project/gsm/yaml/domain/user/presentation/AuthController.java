package project.gsm.yaml.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.gsm.yaml.domain.user.service.RedirectService;
import project.gsm.yaml.domain.user.service.SignInService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final SignInService signInService;
    private final RedirectService redirectService;

    @PostMapping
    public ResponseEntity redirectGAuthInitUrl() {
        return signInService.execute();
    }

    @GetMapping("/redirect")
    public void redirectUrl(@RequestParam(value = "code") String code, HttpServletResponse response) throws IOException {
        redirectService.execute(code);
    }
}
