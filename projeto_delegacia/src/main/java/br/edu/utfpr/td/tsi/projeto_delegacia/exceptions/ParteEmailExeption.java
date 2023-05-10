package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ParteEmailExeption extends RuntimeException {
    public ParteEmailExeption(){
        super(" Formato de E-mail inválido, Exemplo: email@exemplo.com ");
    }
    
}
