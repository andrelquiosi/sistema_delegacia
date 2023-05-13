package br.edu.utfpr.td.tsi.projeto_delegacia.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoletimFurtoVeiculo {
    private String idBoletimFurtoVeiculo;
    private LocalDate dataOcorrencia;
    private PeriodoOcorrencia periodoOcorrencia;
    private Parte parte;
    private Endereco localOcorrencia;
    private String idVeiculoFurtado;
}