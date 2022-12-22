package project.gsm.yaml.domain.user.presentation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class TokenDto {
    private final String accessToken;
    private final String refreshToken;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final ZonedDateTime expiredAt;
}
