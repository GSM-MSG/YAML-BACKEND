package project.gsm.yaml.domain.humanities.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SchoolSportsCompetition {
    NATIONAL(50),
    CITY(30),
    NONE(0);
    private Integer score;
}
