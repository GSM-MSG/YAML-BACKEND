package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.major.entity.Major;

@Getter
@RequiredArgsConstructor
public class InsideContestResponse {

    private final Boolean gsmFestival;

    private final Boolean majorClubPresentation;

    private final Integer afterSchool;

    private final Boolean deepMajorClub;

    public InsideContestResponse(Major major) {
        this.gsmFestival = major.getGsmFestival();
        this.majorClubPresentation = major.getClubMajorPresentation();
        this.afterSchool = major.getAfterSchool();
        this.deepMajorClub = major.getDeepMajorClub();
    }
}
