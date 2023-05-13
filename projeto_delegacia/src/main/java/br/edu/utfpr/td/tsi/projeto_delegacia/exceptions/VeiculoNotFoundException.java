package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VeiculoNotFoundException extends RuntimeException {
    
    public VeiculoNotFoundException() {
        super("Veiculo não encontrado.");
    }
}
