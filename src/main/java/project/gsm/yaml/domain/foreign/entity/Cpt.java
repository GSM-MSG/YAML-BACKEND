package project.gsm.yaml.domain.foreign.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Cpt {
    CPT651(1000),
    CPT501(900),
    CPT351(800),
    CPT201(700),
    NONE(0);

    private Integer score;
}
