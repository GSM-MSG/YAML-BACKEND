package project.gsm.yaml.domain.major.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.major.entity.OutsideAwards;
import project.gsm.yaml.domain.major.entity.OutsideContest;
@AllArgsConstructor
@RequiredArgsConstructor
public class SingleOutsideContestResponse {
    private final Long id;
    private final String name;
    private final String fileURL;

    public SingleOutsideContestResponse(OutsideContest outsideContest) {
        this.id = outsideContest.getId();
        this.name = outsideContest.getName();
        this.fileURL = outsideContest.getFileUrl();
    }
}
