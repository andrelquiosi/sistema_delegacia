package br.edu.utfpr.td.tsi.projeto_delegacia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TipoVeiculo {
    AUTOMOVEL("AUTOMOVEL"),
    MOTOCICLO("MOTOCICLO"),
    CAMINHONETE("CAMINHONETE"),
    CAMIONETA("CAMIONETA"),
    MOTONETA("MOTONETA");

    @Getter
    private String description;

    public static TipoVeiculo fromDescription(String description) {
        for (TipoVeiculo tipo : TipoVeiculo.values()) {
            if (tipo.getDescription().equals(description)) {
                return tipo;
            }
        }
        return null;
    }
}
