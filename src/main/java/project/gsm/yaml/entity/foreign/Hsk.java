package project.gsm.yaml.entity.foreign;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Hsk {
    SIXTH(1000),
    FIFTH(900),
    FORTH(800),
    THIRD(700),
    SECOND(600),
    FIRST(0),
    NONE(0),
    ;
    private Integer score;
}
