package project.gsm.yaml.domain.major.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.gsm.yaml.global.exceptions.ErrorCode;

@Getter
@RequiredArgsConstructor
public class CertificateNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public CertificateNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.CERTIFICATE_NOT_FOUND;
    }
}
