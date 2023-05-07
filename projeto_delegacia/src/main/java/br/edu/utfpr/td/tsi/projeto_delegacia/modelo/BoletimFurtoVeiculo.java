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
    private String idBoletimFurtoVeiculo;

    private Date dataOcorrencia;
    private PeriodoOcorrencia periodoOcorrencia;
    private Parte parte;
    private Endereco localOcorrencia;
    private Veiculo veiculoFurtado;
}