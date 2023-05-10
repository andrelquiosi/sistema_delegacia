package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseErrorResponse {
    private HttpStatus status;
    private int statusCode;
    private String message;

    public BaseErrorResponse(HttpStatus status) {
        super();
        this.status = status;
        this.statusCode = status.value();
    }

    public BaseErrorResponse(HttpStatus status, String message) {
        super();
        this.status = status;
        this.statusCode = status.value();
        this.message = message;
    }
}
