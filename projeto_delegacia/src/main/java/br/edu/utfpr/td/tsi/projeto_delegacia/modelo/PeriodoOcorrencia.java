package br.edu.utfpr.td.tsi.projeto_delegacia.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PeriodoOcorrencia {
    INDETERMINADO("EM HORA INCERTA"),
    MANHA("PELA MANHÃ"),
    TARDE("A TARDE"),
    NOITE("A NOITE"),
    MADRUGADA("DE MADRUGADA");

    @Getter
    private String description;

    public static PeriodoOcorrencia fromDescription(String description) {
        for (PeriodoOcorrencia periodo : PeriodoOcorrencia.values()) {
            if (periodo.getDescription().equals(description)) {
                return periodo;
            }
        }
        return null;
    }
}
