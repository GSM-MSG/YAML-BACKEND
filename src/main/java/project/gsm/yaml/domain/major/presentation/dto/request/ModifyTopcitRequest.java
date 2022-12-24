package project.gsm.yaml.domain.major.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.major.enums.TopcitScore;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@RequiredArgsConstructor
public class ModifyTopcitRequest {
    @Enumerated(EnumType.STRING)
    private final TopcitScore score;

    private final String fileURL;
}
