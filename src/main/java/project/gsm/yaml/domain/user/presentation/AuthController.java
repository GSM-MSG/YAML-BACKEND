package project.gsm.yaml.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.gsm.yaml.domain.user.entity.RefreshToken;
import project.gsm.yaml.domain.user.exception.exceptioncollection.RefreshTokenNotFoundException;
import project.gsm.yaml.domain.user.presentation.dto.TokenDto;
import project.gsm.yaml.domain.user.repository.RefreshTokenRepository;
import project.gsm.yaml.domain.user.service.LogoutService;
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
    private final LogoutService logoutService;

    private final RefreshTokenRepository refreshTokenRepository;

    @PostMapping
    public ResponseEntity redirectGAuthInitUrl() {
        return signInService.execute();
    }

    @GetMapping("/redirect")
    public ResponseEntity<TokenDto> redirectUrl(@RequestParam(value = "code") String code, HttpServletResponse response) throws IOException {
        TokenDto tokenDto = redirectService.execute(code);
        return new ResponseEntity<>(tokenDto, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> logout(@RequestHeader("Authorization")String accessToken){
        logoutService.execute(accessToken);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
