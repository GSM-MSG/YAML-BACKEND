package project.gsm.yaml.domain.humanities.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookMarathon {
    TURTLE(40),
    CROCODILE(70),
    RABBIT(100),
    NONE(100);

    private Integer score;
}
