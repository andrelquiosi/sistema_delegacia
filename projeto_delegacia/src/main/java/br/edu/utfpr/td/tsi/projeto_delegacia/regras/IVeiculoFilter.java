package br.edu.utfpr.td.tsi.projeto_delegacia.regras;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.TipoVeiculo;

public interface IVeiculoFilter {
    public String getPlaca();
    public String getCor();
    public TipoVeiculo getTipo();
}