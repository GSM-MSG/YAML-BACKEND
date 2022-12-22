package project.gsm.yaml.entity.foreign;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Opic {
    INT_2(4),
    INT_1(3),
    INT_LOW(2),
    NOVICE_HIGH(1),
    NONE(0);
    private Integer num;
}
