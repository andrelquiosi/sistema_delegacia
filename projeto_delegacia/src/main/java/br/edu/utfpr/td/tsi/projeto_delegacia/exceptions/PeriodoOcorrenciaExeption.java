package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PeriodoOcorrenciaExeption extends RuntimeException {
    public PeriodoOcorrenciaExeption() {

        super("O periodo deve ser um dos valores: {NOITE, MADRUGADA, MANHA, INDETERMINADO, TARDE}");
    }

}
