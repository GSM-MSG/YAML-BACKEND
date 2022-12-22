package project.gsm.yaml.domain.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.user.service.SignInService;
import project.gsm.yaml.global.security.utils.ConfigUtils;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {
    private final ConfigUtils configUtils;

    @Override
    public ResponseEntity execute() {
        String authUrl = configUtils.gAuthInitUrl();
        URI redirectUri = null;
        try {
            redirectUri = new URI(authUrl);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(redirectUri);
            return new ResponseEntity(headers, HttpStatus.SEE_OTHER);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
