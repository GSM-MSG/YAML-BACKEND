package project.gsm.yaml.domain.foreign.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Jpt {
    JPT700(1000),
    JPT630(900),
    JPT560(800),
    JPT490(700),
    JPT420(600),
    JPT350(500),
    NONE(0);

    private Integer score;
}
