package project.gsm.yaml.domain.user.presentation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GAuthLoginRequest {
    private String clientId;
    private String clientSecret;
    private String code;
}
