package project.gsm.yaml.domain.major.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ModifyTopcitRequest {
    private final String score;

    private final String fileURL;
}
