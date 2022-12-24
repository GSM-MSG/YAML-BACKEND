package project.gsm.yaml.domain.humanities.exceptions;

import lombok.Getter;
import project.gsm.yaml.global.exceptions.ErrorCode;

@Getter
public class PrizeNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;

    public PrizeNotFoundException(String message){
        super(message);
        this.errorCode = ErrorCode.PRIZE_NOT_FOUND;
    }
}
