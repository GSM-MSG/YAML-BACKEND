package project.gsm.yaml.domain.humanities.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CaculateTotalUtil {

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
        score = score + readBook * 10;
        if(score > 200)
            return 200;

        return score;
    }
}
