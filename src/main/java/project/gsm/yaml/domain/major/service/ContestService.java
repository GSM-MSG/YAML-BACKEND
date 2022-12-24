package project.gsm.yaml.domain.major.service;

import project.gsm.yaml.domain.major.presentation.dto.request.OutsideContestRequest;
import project.gsm.yaml.domain.major.presentation.dto.response.ContestResponse;

public interface ContestService {
    ContestResponse getContest();

    void postPrize(OutsideContestRequest outsideContestRequest);
}
