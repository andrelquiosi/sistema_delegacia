package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class VeiculoCorException extends RuntimeException {

    public VeiculoCorException() {
        super("A cor do veículo precisa ser informada.");
    }
    
}
