package project.gsm.yaml.domain.humanities.service;

import project.gsm.yaml.domain.humanities.presentation.dto.response.*;

public interface HumanitiesService {
    PrizeResponse prizeExecute();

    BooksResponse booksExecute();

    VolunteersResponse volunteersExcute();

    HumanitiesCertificateResponse chineseCertificateExecute();
}
