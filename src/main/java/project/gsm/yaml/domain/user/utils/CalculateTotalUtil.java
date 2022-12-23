package project.gsm.yaml.domain.user.utils;

import org.springframework.stereotype.Component;

@Component
public class CalculateTotalUtil {


    public int calculatePrize(int outSidePrize, boolean festival, boolean presentation) {
        int score = 0;
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
