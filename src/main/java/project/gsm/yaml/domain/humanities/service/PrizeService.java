package project.gsm.yaml.domain.humanities.service;

import project.gsm.yaml.domain.humanities.presentation.dto.response.BooksResponse;
import project.gsm.yaml.domain.humanities.presentation.dto.response.PrizeResponse;

public interface PrizeService {
    PrizeResponse prizeExecute(String accessToken);

    BooksResponse booksExecute(String accessToken);
}
