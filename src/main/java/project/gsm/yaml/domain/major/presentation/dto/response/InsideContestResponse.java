package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class InsideContestResponse {

    private final Boolean gsmFestival;

    private final Boolean majorClubPresentation;

    private final Integer afterSchool;

    private final Boolean deepMajorClub;
}
