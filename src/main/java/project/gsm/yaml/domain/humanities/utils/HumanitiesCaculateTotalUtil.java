package project.gsm.yaml.domain.humanities.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HumanitiesCaculateTotalUtil {

    private int score = 0;

    public int calculatePrize(int Awards) {
        score = 0;

        score = score + Awards * 50;

        if(score > 250)
            return 250;

        return score;
    }

    public int calculateBooks(int bookMarathon, int readBook){
        score = 0;
        score = score + bookMarathon;

        score += Math.min(10, readBook) * 10;

        if(score > 200)
            return 200;

        return score;
    }

    public int calculateVounteers(int hour){
        score = 0;
        score = score + hour * 10;

        if(score > 300)
            return 300;

        return score;
    }

    public int calculateHumanitiesCertificate(int chinese, int history){
        score = 0;
        score += chinese;
        score += history;
        return score;
    }

    public int calculateSports(int marathon, int schoolLeague, int sportsClubContest){
        score = 0;
        score += marathon;
        score += schoolLeague;
        score += sportsClubContest;
        return score;
    }
}
