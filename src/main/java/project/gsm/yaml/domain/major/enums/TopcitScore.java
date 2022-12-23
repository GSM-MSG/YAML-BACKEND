package project.gsm.yaml.domain.major.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TopcitScore {
    UPPER_240(100),
    UPPER_220(95),
    UPPER_200(90),
    UPPER_180(85),
    UPPER_160(80),
    NONE(0);
    private final Integer score;
}
