package project.gsm.yaml.domain.humanities.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gsm.yaml.domain.humanities.entity.Humanities;
import project.gsm.yaml.domain.humanities.entity.Sports;
import project.gsm.yaml.domain.humanities.presentation.dto.request.ModifySportsRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.response.SportsResponse;
import project.gsm.yaml.domain.humanities.service.SportsService;
import project.gsm.yaml.domain.humanities.utils.HumanitiesCaculateTotalUtil;
import project.gsm.yaml.domain.user.utils.UserUtil;

@Service
@RequiredArgsConstructor
public class SportsServiceImpl implements SportsService {
    private final UserUtil userUtil;
    private final HumanitiesCaculateTotalUtil caculateTotalUtil;

    @Override
    public SportsResponse sportsExecute(){
        Sports sports = userUtil.currentUser().getHumanities().getSports();
        int marathonScore = sports.getMarathon().getScore();
        int leagueScore = sports.getInnerLeague().getScore();
        int contestScore = sports.getSchoolCompetition().getScore();
        int total = caculateTotalUtil.calculateSports(marathonScore, leagueScore, contestScore);
        return SportsResponse.builder()
                .marathon(sports.getMarathon())
                .innerLeague(sports.getInnerLeague())
                .schoolCompetition(sports.getSchoolCompetition())
                .build();
    }

    @Override
    public void patchSportsExecute(ModifySportsRequest modifySportsRequest) {
        Sports sports = userUtil.currentUser().getHumanities().getSports();
        sports.update(modifySportsRequest.getMarathon(), modifySportsRequest.getInnerLeague(), modifySportsRequest.getSchoolSportsCompetition(), modifySportsRequest.getTotal());
    }
}
