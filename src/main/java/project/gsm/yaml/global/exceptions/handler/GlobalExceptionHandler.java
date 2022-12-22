package project.gsm.yaml.global.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.gsm.yaml.domain.user.exception.exceptioncollection.BlackListAlreadyExistException;
import project.gsm.yaml.domain.user.exception.exceptioncollection.RefreshTokenNotFoundException;
import project.gsm.yaml.global.exceptions.ErrorResponse;
import project.gsm.yaml.global.exceptions.exceptioncollection.TokenExpirationException;
import project.gsm.yaml.global.exceptions.exceptioncollection.TokenNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TokenExpirationException.class)
    public ResponseEntity<ErrorResponse> TokenExpiration(TokenExpirationException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(TokenNotValidException.class)
    public ResponseEntity<ErrorResponse> TokenNotValid(TokenNotValidException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(RefreshTokenNotFoundException.class)
    public ResponseEntity<ErrorResponse> RefreshTokenNotFound(RefreshTokenNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(BlackListAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> BlackListAlreadyExist(BlackListAlreadyExistException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }
}
