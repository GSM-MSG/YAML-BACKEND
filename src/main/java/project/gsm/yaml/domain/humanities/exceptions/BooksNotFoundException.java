package project.gsm.yaml.domain.humanities.exceptions;

import lombok.Getter;
import project.gsm.yaml.global.exceptions.ErrorCode;

@Getter
public class BooksNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;

    public BooksNotFoundException(String message){
        super(message);
        this.errorCode = ErrorCode.BOOK_NOT_FOUND;
    }
}
