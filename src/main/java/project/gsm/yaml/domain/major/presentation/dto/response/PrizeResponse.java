package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Builder
public class PrizeResponse {

    private final List<SingleOutsideResponse> outsideAwardsList;

    private final Boolean gsmFestival;

    private final Boolean majorClubPresentation;

    private final Integer total;
}
