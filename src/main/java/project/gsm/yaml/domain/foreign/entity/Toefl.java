package project.gsm.yaml.domain.foreign.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Toefl {
    TOEFL80(1000),
    TOEFL75(900),
    TOEFL70(800),
    TOEFL65(700),
    TOEFL60(600),
    TOEFL55(500),
    NONE(0);

    private Integer score;
}
