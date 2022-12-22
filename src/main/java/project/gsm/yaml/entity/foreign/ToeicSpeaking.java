package project.gsm.yaml.entity.foreign;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ToeicSpeaking {
    LEVEL_9(1000),
    LEVEL_8(1000),
    LEVEL_7(1000),
    LEVEL_6(1000),
    LEVEL_5(900),
    LEVEL_4(800),
    LEVEL_3(700),
    LEVEL_2(0),
    LEVEL_1(0),
    LEVEL_0(0),
    NONE(0);
    private Integer score;
}
