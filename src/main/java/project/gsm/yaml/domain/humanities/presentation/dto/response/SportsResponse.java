package project.gsm.yaml.domain.humanities.presentation.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.InnerSportsLeague;
import project.gsm.yaml.domain.humanities.entity.Marathon;
import project.gsm.yaml.domain.humanities.entity.SchoolSportsCompetition;
import project.gsm.yaml.domain.humanities.entity.Sports;

@RequiredArgsConstructor
@Builder
public class SportsResponse {
    private Long id;
    private Marathon marathon;
    private InnerSportsLeague innerLeague;
    private SchoolSportsCompetition schoolCompetition;
    private Integer total;

    public SportsResponse(Sports sports){
        this.id = sports.getId();
        this.marathon = sports.getMarathon();
        this.innerLeague = sports.getInnerLeague();
        this.schoolCompetition = sports.getSchoolCompetition();
        this.total = sports.getTotal();
    }
}
