package project.gsm.yaml.domain.humanities.presentation.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Builder
public class PrizeResponse {
    private final List<AwardsResponse> list;
    private final Integer total;
}
