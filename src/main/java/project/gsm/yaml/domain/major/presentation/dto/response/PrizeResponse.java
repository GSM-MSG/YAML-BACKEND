package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PrizeResponse {

    private final List<SingleOutsidePrizeResponse> outside;

    private final InsidePrizeResponse inside;

    private final Integer total;
}
