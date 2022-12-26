package project.gsm.yaml.domain.foreign.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Toeic {
    TOEIC700(1000),
    TOEIC630(900),
    TOEIC560(800),
    TOEIC490(700),
    TOEIC420(600),
    TOEIC350(500),
    NONE(0);

    private Integer score;
}
