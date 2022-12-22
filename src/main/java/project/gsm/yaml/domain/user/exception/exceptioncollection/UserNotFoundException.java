package project.gsm.yaml.domain.user.exception.exceptioncollection;

import lombok.Getter;
import project.gsm.yaml.global.exceptions.ErrorCode;

@Getter
public class UserNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;

    public UserNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.USER_NOT_FOUND;
    }
}
