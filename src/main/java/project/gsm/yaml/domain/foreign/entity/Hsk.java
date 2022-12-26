package project.gsm.yaml.domain.foreign.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Hsk {
    SIX(1000),
    FIVE(900),
    FOUR(800),
    THREE(700),
    TWO(600),
    NONE(0);

    private Integer score;
}
