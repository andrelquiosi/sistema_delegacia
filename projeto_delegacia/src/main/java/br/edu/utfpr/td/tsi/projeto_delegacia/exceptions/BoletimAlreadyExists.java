package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class BoletimAlreadyExists extends RuntimeException {
    
    public BoletimAlreadyExists() {
        super("Um boletim já foi cadastrado com este identificador.");
    }
}
