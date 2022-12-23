package project.gsm.yaml.domain.humanities.service;

import project.gsm.yaml.domain.humanities.presentation.dto.response.BooksResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.PrizeResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.VolunteersResponse;

public interface PrizeService {
    PrizeResponse prizeExecute();

    BooksResponse booksExecute();

    VolunteersResponse volunteersExecute();
}
