package project.gsm.yaml.domain.major.exceptions;

import lombok.Getter;
import project.gsm.yaml.global.exceptions.ErrorCode;

@Getter
public class AwardsNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;

    public AwardsNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.AWARDS_NOT_FOUND;
    }
}
