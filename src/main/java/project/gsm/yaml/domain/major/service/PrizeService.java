package project.gsm.yaml.domain.major.service;

import project.gsm.yaml.domain.major.presentation.dto.request.ModifyOutsidePrizeRequest;
import project.gsm.yaml.domain.major.presentation.dto.request.OutsidePrizeRequest;
import project.gsm.yaml.domain.major.presentation.dto.response.PrizeResponse;

public interface PrizeService {
    PrizeResponse getPrize();

    void postPrize(OutsidePrizeRequest outsidePrizeRequest);

    void patchPrize(Long id, ModifyOutsidePrizeRequest modifyOutsidePrizeRequest);
}
