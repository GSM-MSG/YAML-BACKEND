package project.gsm.yaml.entity.foreign;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ToeicSpeaking {
    LEVEL_6(1000),
    LEVEL_5(900),
    LEVEL_4(800),
    LEVEL_3(700),
    NONE(0);
    private Integer score;
}
