package br.edu.utfpr.td.tsi.projeto_delegacia.regras;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.PeriodoOcorrencia;

public interface IBoletimFilter {
    public String getCidade();
    public PeriodoOcorrencia getPeriodoOcorrencia();
}
