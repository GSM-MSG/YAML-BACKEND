package project.gsm.yaml.domain.humanities.service;

import project.gsm.yaml.domain.humanities.presentation.dto.request.BooksRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.request.ModifyBookMarathonRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.request.ModifyBooksRequest;
import project.gsm.yaml.domain.humanities.presentation.dto.response.BooksResponse;

public interface BookService {
    BooksResponse booksExecute();

    void postBooksExecute(BooksRequest booksRequest);

    void patchBooksExecute(Long id, ModifyBooksRequest modifyBooksRequest);

    void patchBooksMarathonExecute(ModifyBookMarathonRequest modifyBookMarathonRequest);

    void deleteBooksExecute(Long id);
}
