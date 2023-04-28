package br.edu.utfpr.td.tsi.projeto_delegacia.modelo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoletimFurtoVeiculo {

    @NonNull
    private Long idBoletimFurtoVeiculo;

    private Date dataOcorrencia;
    private String periodoOcorrencia;
    private Parte parte;
    private Endereco localOcorrencia;
    private Veiculo veiculoFurtado;
}