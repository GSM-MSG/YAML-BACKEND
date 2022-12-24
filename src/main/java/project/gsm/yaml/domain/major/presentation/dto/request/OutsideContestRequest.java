package project.gsm.yaml.domain.major.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OutsideContestRequest {

    private final String name;

    private final String fileURL;
}
