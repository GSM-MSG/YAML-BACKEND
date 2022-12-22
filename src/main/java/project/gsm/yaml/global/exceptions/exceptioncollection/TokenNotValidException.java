package project.gsm.yaml.global.exceptions.exceptioncollection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.global.exceptions.ErrorCode;

@Getter
@RequiredArgsConstructor
public class TokenNotValidException extends RuntimeException{
    private final ErrorCode errorCode;
    public TokenNotValidException(String message) {
        super(message);
        this.errorCode = ErrorCode.TOKEN_NOT_VALID;
    }
}
