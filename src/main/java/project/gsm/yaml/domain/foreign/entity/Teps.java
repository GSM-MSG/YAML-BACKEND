package project.gsm.yaml.domain.foreign.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Teps {
    TEPS555(1000),
    TEPS520(900),
    TEPS480(800),
    TEPS440(700),
    TEPS400(600),
    TEPS360(500),
    NONE(0);

    private Integer score;
}
