package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.handlers;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.BaseErrorResponse;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request) {
        BaseErrorResponse baseErrorResponse = new BaseErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        return buildResponseEntity(baseErrorResponse);
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(
        HttpMessageNotReadableException e, WebRequest request
    ) {

        String message = "Erro esquisito: " + e.getCause().getClass().getName();
        Throwable cause = e.getCause();

        if (cause instanceof InvalidFormatException) {
            message = "JSON mal formatado: " + ((InvalidFormatException) cause).getTargetType().getSimpleName();
        }

        BaseErrorResponse baseErrorResponse = new BaseErrorResponse(HttpStatus.BAD_REQUEST, message);

        return buildResponseEntity(baseErrorResponse);
    }

    private ResponseEntity<Object> buildResponseEntity(BaseErrorResponse baseErrorResponse) {
        return new ResponseEntity<>(baseErrorResponse, baseErrorResponse.getStatus());
    }

}
