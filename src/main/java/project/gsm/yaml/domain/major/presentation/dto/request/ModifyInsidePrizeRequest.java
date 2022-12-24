package project.gsm.yaml.domain.major.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ModifyInsidePrizeRequest {

    private final Boolean gsmFestival;

    private final Boolean majorClubPresentation;
}
