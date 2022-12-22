package project.gsm.yaml.domain.humanities.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Marathon {
    HALF(50),
    TEN(30),
    FIVE(20),
    NONE(0);
    private Integer score;
}
