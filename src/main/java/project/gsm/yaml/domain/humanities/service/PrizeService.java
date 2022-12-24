package project.gsm.yaml.domain.humanities.service;

import project.gsm.yaml.domain.humanities.presentation.dto.request.BooksRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.request.PrizeRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.response.*;

public interface PrizeService {
    PrizeResponse prizeExecute();

    void postPrizeExecute(PrizeRequest prizeRequest);
}
