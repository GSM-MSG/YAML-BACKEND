package project.gsm.yaml.domain.foreign.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Opic {
    INT_2(1000),
    INT_1(900),
    INT_LOW(800),
    NOVICE_HIGH(700),
    NONE(0);

    private Integer score;
}
