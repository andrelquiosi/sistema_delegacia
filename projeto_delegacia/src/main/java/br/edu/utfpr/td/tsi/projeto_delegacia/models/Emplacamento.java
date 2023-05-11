package br.edu.utfpr.td.tsi.projeto_delegacia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emplacamento {
    private String placa;
    private String estado;
    private String cidade;
}
