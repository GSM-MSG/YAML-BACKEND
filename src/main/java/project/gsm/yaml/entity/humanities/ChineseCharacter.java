package project.gsm.yaml.entity.humanities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChineseCharacter {
    SPECIAL(50),
    SEMI_SPECIAL(50),
    FIRST(50),
    SECOND(50),
    THIRD(50),
    SEMI_THIRD(50),
    FORTH(50),
    SEMI_FORTH(0),
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
