package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class VeiculoTipoVeiculoException extends RuntimeException {
    
    public VeiculoTipoVeiculoException() {
        super("Tipo de veículo não informado.");
    }
}
