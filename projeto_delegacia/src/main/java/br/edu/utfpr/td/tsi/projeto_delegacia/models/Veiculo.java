package br.edu.utfpr.td.tsi.projeto_delegacia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @NonNull
    private String idVeiculo;

    private Integer anoFabricacao;
    private String cor;
    private String marca;
    private TipoVeiculo tipoVeiculo;
    private Emplacamento emplacamento;

}
