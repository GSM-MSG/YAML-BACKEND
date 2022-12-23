package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.major.enums.TopcitScore;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class TopcitResponse {
    private final TopcitScore score;
    private final String fileURL;
    private final Integer total;
}
