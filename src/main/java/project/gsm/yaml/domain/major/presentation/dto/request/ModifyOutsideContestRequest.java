package project.gsm.yaml.domain.major.presentation.dto.request;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ModifyOutsideContestRequest {
    private final String name;

    private final String fileURL;
}
