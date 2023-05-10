package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class VeiculoTipoExeption extends RuntimeException {
    public VeiculoTipoExeption() {
        super("O tipo do veículo deve ser um dos valores: {MOTONETA, MOTOCICLO, AUTOMOVEL, CAMIONETA, CAMINHONETE}");
    }

}
