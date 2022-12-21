package project.gsm.yaml.domain.user.presentation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GAuthLoginResponse {
    private String accessToken;
    private String refreshToken;
}
