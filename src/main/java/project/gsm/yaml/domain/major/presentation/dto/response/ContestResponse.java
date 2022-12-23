package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ContestResponse {

    private final List<SingleOutsideContestResponse> outside;

    private final InsideContestResponse inside;

    private final Integer total;

}
