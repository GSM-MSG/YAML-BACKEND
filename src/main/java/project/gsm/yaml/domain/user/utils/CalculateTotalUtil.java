package project.gsm.yaml.domain.user.utils;

import org.springframework.stereotype.Component;

@Component
public class CalculateTotalUtil {

    private int score = 0;

    public int calculatePrize(int outSidePrize, boolean festival, boolean presentation) {
        score = score + outSidePrize * 50;
        if(festival)
            score = score+50;

        if(presentation)
            score = score+50;

        if(score >= 250)
            return 250;

        return score;
    }
}
