package project.gsm.yaml.domain.major.utils;

import org.springframework.stereotype.Component;

@Component
public class CalculateTotalUtil {


    public int calculatePrize(int outSidePrize, boolean festival, boolean presentation) {
        int score = 0;
        score = outSidePrize * 50;
        if(festival)
            score = score+50;

        if(presentation)
            score = score+50;

        if(score > 250)
            return 250;

        return score;
    }

    public int calculateContest(int outsideContest, int afterSchool, Boolean festival, boolean presentation, boolean deepMajorClub){
        int score = 0;

        if(outsideContest > 8)
            score = 200;
        else
            score = outsideContest * 25;

        if(afterSchool > 5)
            score = score + 50;
        else
            score = score + afterSchool * 10;

        if(festival)
            score = score +50;

        if(presentation)
            score = score +50;

        if(deepMajorClub)
            score = score +50;

        if(score > 400)
            return 400;

        return score;
    }
}
