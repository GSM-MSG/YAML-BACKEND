package project.gsm.yaml.domain.major.service;

import project.gsm.yaml.domain.major.presentation.dto.request.ModifyMajorClubRequest;
import project.gsm.yaml.domain.major.presentation.dto.response.MajorClubResponse;

public interface MajorClubService {
    MajorClubResponse getMajorClub();

    void patchMajorClub(ModifyMajorClubRequest modifyMajorClubRequest);
}
