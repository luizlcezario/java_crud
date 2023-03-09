package me.dio.academia.digital.infra.erros;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private HttpStatus _status = HttpStatus.INTERNAL_SERVER_ERROR;

    public CustomException(String message, HttpStatus status) {
        super(message);
        this._status = status;
    }

    public HttpStatus getStatus() {
        return _status;
    }
}