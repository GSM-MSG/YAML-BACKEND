package project.gsm.yaml.global.exceptions.exceptioncollection;


import lombok.Getter;
import project.gsm.yaml.global.exceptions.ErrorCode;

@Getter
public class TokenExpirationException extends RuntimeException{
    private final ErrorCode errorCode;
    public TokenExpirationException(String message){
        super(message);
        this.errorCode = ErrorCode.TOKEN_EXPIRATION;
    }
}
