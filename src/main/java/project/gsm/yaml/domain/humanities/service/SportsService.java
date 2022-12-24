package project.gsm.yaml.domain.humanities.service;

import project.gsm.yaml.domain.humanities.presentation.dto.request.ModifySportsRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.response.SportsResponse;

public interface SportsService {
    SportsResponse sportsExecute();

    void patchSportsExecute(ModifySportsRequest modifySportsRequest);
}
