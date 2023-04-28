package br.edu.utfpr.td.tsi.projeto_delegacia.modelo;

import lombok.Data;

@Data
public class Endereco {

    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

}
