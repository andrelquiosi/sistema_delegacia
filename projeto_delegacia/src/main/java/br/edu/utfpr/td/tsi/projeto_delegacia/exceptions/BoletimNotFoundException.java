package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BoletimNotFoundException extends RuntimeException {
    
    public BoletimNotFoundException() {
        super("O boletim de ocorrência não foi encontrado");
    }
}
