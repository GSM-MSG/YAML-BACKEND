package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Builder
public class ContestResponse {

    private final List<SingleOutsideContestResponse> outside;

    private final InsideContestResponse inside;

    private final Integer total;

}
