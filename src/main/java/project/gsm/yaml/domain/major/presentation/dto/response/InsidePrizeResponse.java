package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class InsidePrizeResponse {

    private final Boolean gsmFestival;

    private final Boolean majorClubPresentation;
}
