package project.gsm.yaml.domain.foreign;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Hsk {
    SIXTH(1000),
    FIFTH(900),
    FOURTH(800),
    THIRD(700),
    SECOND(600),
    NONE(0),
    ;
    private Integer score;
}
