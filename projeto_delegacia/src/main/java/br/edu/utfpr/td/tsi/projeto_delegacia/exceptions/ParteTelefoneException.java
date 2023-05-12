package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ParteTelefoneException extends RuntimeException {

    public ParteTelefoneException() {
        super("Formato do Telefone inválido, Exemplo: (99) 9 9999-9999.");
    }
     
}
