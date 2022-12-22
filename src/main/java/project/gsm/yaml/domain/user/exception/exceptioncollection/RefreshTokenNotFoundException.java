package project.gsm.yaml.domain.user.exception.exceptioncollection;

import lombok.Getter;
import project.gsm.yaml.global.exceptions.ErrorCode;

@Getter
public class RefreshTokenNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public RefreshTokenNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.REFRESH_TOKEN_NOT_FOUND;
    }
}
