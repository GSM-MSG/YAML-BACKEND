package project.gsm.yaml.domain.humanities.service;

import project.gsm.yaml.domain.humanities.presentation.dto.request.BooksRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.response.BooksResponse;

public interface BookService {
    BooksResponse booksExecute();

    void postBooksExecute(BooksRequest booksRequest);
}