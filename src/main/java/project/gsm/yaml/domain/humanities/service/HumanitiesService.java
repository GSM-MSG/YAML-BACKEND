package project.gsm.yaml.domain.humanities.service;

import project.gsm.yaml.domain.humanities.presentation.dto.request.PrizeRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.response.*;

public interface HumanitiesService {
    PrizeResponse prizeExecute();

    BooksResponse booksExecute();

    VolunteersResponse volunteersExecute();

    HumanitiesCertificateResponse humanitiesCertificateExecute();

    SportsResponse sportsExecute();

    void postPrizeExecute(PrizeRequest prizeRequest);
}
