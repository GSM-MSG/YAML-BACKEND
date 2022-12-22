package project.gsm.yaml.entity.humanities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InnerSportsLeague {
    THREE(50),
    TWO(30),
    ONE(20),
    NONE(0);
    private Integer score;
}
