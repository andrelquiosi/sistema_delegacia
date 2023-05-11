package br.edu.utfpr.td.tsi.projeto_delegacia.models;

import java.time.LocalDate;

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

    private LocalDate dataOcorrencia;
    private PeriodoOcorrencia periodoOcorrencia;
    private Parte parte;
    private Endereco localOcorrencia;
    private Veiculo veiculoFurtado;
}