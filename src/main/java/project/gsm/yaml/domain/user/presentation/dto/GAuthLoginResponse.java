package project.gsm.yaml.domain.user.presentation.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GAuthLoginResponse {
    private final String accessToken;
    private final String refreshToken;
}
