package project.gsm.yaml.domain.humanities.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChineseLevel {
    SPECIAL(50),
    SEMI_SPECIAL(50),
    FIRST(50),
    SECOND(50),
    THIRD(50),
    SEMI_THIRD(50),
    FOURTH(50),
    SEMI_FOURTH(0),
    FIFTH(0),
    SEMI_FIFTH(0),
    SIXTH(0),
    SEMI_SIXTH(0),
    SEVENTH(0),
    SEMI_SEVENTH(0),
    EIGHTH(0),
    NONE(0);
    private Integer score;
}
