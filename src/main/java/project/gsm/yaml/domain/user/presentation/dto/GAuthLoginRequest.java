package project.gsm.yaml.domain.user.presentation.dto;

import lombok.Builder;

@Builder
public class GAuthLoginRequest {
    private final String clientId;
    private final String clientSecret;
    private final String code;
}
