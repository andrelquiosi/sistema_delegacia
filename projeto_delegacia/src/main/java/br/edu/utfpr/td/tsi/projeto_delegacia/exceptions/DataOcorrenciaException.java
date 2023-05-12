package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DataOcorrenciaException extends RuntimeException {
    
    public DataOcorrenciaException() {
        super("dataOcorrencia Incorreta. Informe uma data e que não esteja no futuro ");
    }
}
