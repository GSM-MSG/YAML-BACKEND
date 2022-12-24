package project.gsm.yaml.domain.major.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.global.exceptions.ErrorCode;

@Getter
@RequiredArgsConstructor
public class ContestNotFoundException extends RuntimeException {

    private final ErrorCode errorCode;

    public ContestNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.CONTEST_NOT_FOUND;
    }
}
