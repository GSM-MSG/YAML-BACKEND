package project.gsm.yaml.domain.humanities.utils;

import org.springframework.stereotype.Component;

@Component
public class CaculateTotalUtil {
    private int score = 0;

    public int calculatePrize(int Awards) {
        int score = 0;
        score = score + Awards * 50;
        if(score > 250)
            return 250;

        return score;
    }
}
