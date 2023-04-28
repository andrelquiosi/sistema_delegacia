package br.edu.utfpr.td.tsi.projeto_delegacia.modelo;

import lombok.Data;

@Data
public class Veiculo {

    private int anoFabricacao;
    private String cor;
    private String marca;
    private String tipoVeiculo;
    private Emplacamento emplacamento;

}
