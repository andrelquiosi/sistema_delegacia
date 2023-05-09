package br.edu.utfpr.td.tsi.projeto_delegacia.rules;

import br.edu.utfpr.td.tsi.projeto_delegacia.model.PeriodoOcorrencia;

public interface IBoletimFilter {
    public String getCidade();
    public PeriodoOcorrencia getPeriodoOcorrencia();
}
