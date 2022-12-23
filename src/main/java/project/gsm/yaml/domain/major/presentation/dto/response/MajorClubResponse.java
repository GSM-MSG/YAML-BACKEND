package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class MajorClubResponse {

    private final String name;

    private final Integer total;
}
