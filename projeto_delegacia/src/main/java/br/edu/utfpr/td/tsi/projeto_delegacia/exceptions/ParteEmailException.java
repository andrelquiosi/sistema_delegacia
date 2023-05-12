package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ParteEmailException extends RuntimeException {

    public ParteEmailException() {
        super("O e-mail informado não é válido, exemplo: email@exemplo.com.");
    }
    
}
