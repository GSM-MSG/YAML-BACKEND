package project.gsm.yaml.domain.humanities.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum KoreanHistoryRating {
    FIRST(50),
    SECOND(50),
    THIRD(50),
    FOURTH(0),
    FIFTH(0),
    SIXTH(0),
    NONE(0);
    private Integer score;
}
