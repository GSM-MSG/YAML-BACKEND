package project.gsm.yaml.domain.major.service;

import project.gsm.yaml.domain.major.presentation.dto.request.ModifyOutsideContestRequest;
import project.gsm.yaml.domain.major.presentation.dto.request.OutsideContestRequest;
import project.gsm.yaml.domain.major.presentation.dto.response.ContestResponse;

public interface ContestService {
    ContestResponse getContest();

    void postContest(OutsideContestRequest outsideContestRequest);

    void patchOutsideContest(Long id, ModifyOutsideContestRequest modifyOutsideContestRequest);
}
