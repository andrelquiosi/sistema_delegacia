package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EnderecoCidadeException extends RuntimeException {

    public EnderecoCidadeException() {
        super("Cidade deve ser informada.");
    }
    
}
