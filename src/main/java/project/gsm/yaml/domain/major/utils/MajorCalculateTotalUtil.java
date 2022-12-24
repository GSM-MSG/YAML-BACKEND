package project.gsm.yaml.domain.major.utils;

import org.springframework.stereotype.Component;
import project.gsm.yaml.domain.major.enums.TopcitScore;
import project.gsm.yaml.domain.major.presentation.dto.response.InsideContestResponse;
import project.gsm.yaml.domain.major.presentation.dto.response.InsidePrizeResponse;

@Component
public class MajorCalculateTotalUtil {


    public int calculateMajorPrize(int outSidePrize, InsidePrizeResponse insidePrizeResponse) {
        int score = 0;
        score = outSidePrize * 50;
        if(insidePrizeResponse.getGsmFestival())
            score = score+50;

        if(insidePrizeResponse.getMajorClubPresentation())
            score = score+50;

        return Math.min(250, score);
    }

    public int calculateMajorContest(int outsideContest, int afterSchool, InsideContestResponse insideContestResponse){
        int score = 0;

        score += Math.min(8, outsideContest) * 25;

        score += Math.min(5, afterSchool) * 10;


        if(insideContestResponse.getAttendGsmFestival())
            score = score +50;

        if(insideContestResponse.getAttendMajorClubPresentation())
            score = score +50;

        if(insideContestResponse.getDeepMajorClub())
            score = score +50;

        return Math.min(400, score);
    }

    public int calculateMajorClub(String majorClub) {
        if(majorClub.isBlank())
            return 0;

        return 150;
    }

    public int calculateCertificate(int certificate) {
        int score = 0;

        return score += Math.min(5, certificate) * 20;
    }

    public int calculateTopcit(TopcitScore topcitScore) {
        return topcitScore.getScore();
    }
}
