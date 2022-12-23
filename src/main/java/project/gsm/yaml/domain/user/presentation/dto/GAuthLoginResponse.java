package project.gsm.yaml.domain.user.presentation.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GAuthLoginResponse {
    private final String accessToken;
    private final String refreshToken;
}
