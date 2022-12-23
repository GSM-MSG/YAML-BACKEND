package project.gsm.yaml.domain.humanities.presentation.dto.response;

import lombok.RequiredArgsConstructor;
import project.gsm.yaml.domain.humanities.entity.Book;

@RequiredArgsConstructor
public class BookResponse {
    private Long id;
    private String name;
    private String author;
    private String field;
    private String review;

    public BookResponse(Book book){
        this.id = book.getId();
        this.name = book.getName();
        this.author = book.getAuthor();
        this.field = book.getField();
        this.review = book.getReview();
    }
}