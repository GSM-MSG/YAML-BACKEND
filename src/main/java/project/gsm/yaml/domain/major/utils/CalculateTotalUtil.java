package project.gsm.yaml.domain.major.utils;

import org.springframework.stereotype.Component;
import project.gsm.yaml.domain.major.presentation.dto.response.InsideContestResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.InsidePrizeResponse;

@Component
public class CalculateTotalUtil {


    public int calculatePrize(int outSidePrize, InsidePrizeResponse insidePrizeResponse) {
        int score = 0;
        score = outSidePrize * 50;
        if(insidePrizeResponse.getGsmFestival())
            score = score+50;

        if(insidePrizeResponse.getMajorClubPresentation())
            score = score+50;

        if(score > 250)
            return 250;

        return score;
    }

    public int calculateContest(int outsideContest, int afterSchool, InsideContestResponse insideContestResponse){
        int score = 0;

        if(outsideContest > 8)
            score = 200;
        else
            score = outsideContest * 25;

        if(afterSchool > 5)
            score = score + 50;
        else
            score = score + afterSchool * 10;

        if(insideContestResponse.getGsmFestival())
            score = score +50;

        if(insideContestResponse.getMajorClubPresentation())
            score = score +50;

        if(insideContestResponse.getDeepMajorClub())
            score = score +50;

        if(score > 400)
            return 400;

        return score;
    }
}
