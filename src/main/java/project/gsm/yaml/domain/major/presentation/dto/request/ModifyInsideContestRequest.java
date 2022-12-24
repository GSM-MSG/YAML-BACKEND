package project.gsm.yaml.domain.major.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ModifyInsideContestRequest {
    
    private Boolean attendGsmFestival;

    private Boolean attendClubMajorPresentation;
}
