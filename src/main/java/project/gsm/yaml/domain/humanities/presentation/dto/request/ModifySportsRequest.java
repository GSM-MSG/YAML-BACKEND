package project.gsm.yaml.domain.humanities.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.InnerSportsLeague;
import project.gsm.yaml.domain.humanities.entity.Marathon;
import project.gsm.yaml.domain.humanities.entity.SchoolSportsCompetition;

@Getter
@RequiredArgsConstructor
public class ModifySportsRequest {
    private final Marathon marathon;
    private final InnerSportsLeague innerLeague;
    private final SchoolSportsCompetition schoolSportsCompetition;
    private final Integer total;
}
