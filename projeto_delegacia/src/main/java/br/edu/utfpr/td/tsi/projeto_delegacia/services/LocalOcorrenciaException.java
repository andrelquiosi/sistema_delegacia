package br.edu.utfpr.td.tsi.projeto_delegacia.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LocalOcorrenciaException extends RuntimeException {

    public LocalOcorrenciaException() {
        super("Local de Ocorrência não informado.");
    }
}
