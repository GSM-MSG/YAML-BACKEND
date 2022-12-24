package project.gsm.yaml.domain.humanities.exceptions;

import lombok.Getter;
import project.gsm.yaml.global.exceptions.ErrorCode;

@Getter
public class VolunteerNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;

    public VolunteerNotFoundException(String message){
        super(message);
        this.errorCode = ErrorCode.VOLUNTEER_NOT_FOUND;
    }
}
