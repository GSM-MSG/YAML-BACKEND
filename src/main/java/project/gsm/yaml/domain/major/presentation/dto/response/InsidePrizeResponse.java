package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.major.entity.Major;

@RequiredArgsConstructor
@Builder
@Getter
public class InsidePrizeResponse {

    private final Boolean gsmFestival;

    private final Boolean majorClubPresentation;

    public InsidePrizeResponse(Major major) {
        this.gsmFestival = major.getGsmFestival();
        this.majorClubPresentation = major.getClubMajorPresentation();
    }
}
