package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.major.entity.Major;

@Getter
@RequiredArgsConstructor
public class InsideContestResponse {

    private final Boolean attendGsmFestival;

    private final Boolean attendMajorClubPresentation;

    private final Integer afterSchool;

    private final Boolean deepMajorClub;

    public InsideContestResponse(Major major) {
        this.attendGsmFestival = major.getAttendGsmFestival();
        this.attendMajorClubPresentation = major.getAttendClubMajorPresentation();
        this.afterSchool = major.getAfterSchool();
        this.deepMajorClub = major.getDeepMajorClub();
    }
}
