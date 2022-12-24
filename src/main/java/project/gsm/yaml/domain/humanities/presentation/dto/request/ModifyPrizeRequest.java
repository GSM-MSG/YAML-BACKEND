package project.gsm.yaml.domain.humanities.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ModifyPrizeRequest {
    private final String name;
    private final String fileURL;
}
