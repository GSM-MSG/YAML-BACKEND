package project.gsm.yaml.domain.humanities.service;

import project.gsm.yaml.domain.humanities.presentation.dto.response.BooksResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.ChineseCertificateResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.PrizeResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.VolunteersResponse;

public interface HumanitiesService {
    PrizeResponse prizeExecute();

    BooksResponse booksExecute();

    VolunteersResponse volunteersExcute();

    ChineseCertificateResponse chineseCertificateExecute();
}
