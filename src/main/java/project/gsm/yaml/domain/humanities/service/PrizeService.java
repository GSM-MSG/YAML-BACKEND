package project.gsm.yaml.domain.humanities.service;

import project.gsm.yaml.domain.humanities.presentation.dto.request.ModifyPrizeRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.request.PrizeRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.response.*;

public interface PrizeService {
    PrizeResponse prizeExecute();

    void postPrizeExecute(PrizeRequest prizeRequest);

    void patchPrizeExecute(Long id, ModifyPrizeRequest modifyPrizeRequest);

    void deletePrizeExecute(Long id);
}
