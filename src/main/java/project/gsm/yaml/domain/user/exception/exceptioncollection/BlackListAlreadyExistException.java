package project.gsm.yaml.domain.user.exception.exceptioncollection;



import lombok.Getter;
import project.gsm.yaml.global.exceptions.ErrorCode;

@Getter
public class BlackListAlreadyExistException extends RuntimeException {
    private final ErrorCode errorCode;

    public BlackListAlreadyExistException(String message) {
        super(message);
        this.errorCode = ErrorCode.BLACK_LIST_ALREADY_EXIST;
    }
}
