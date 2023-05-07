package br.edu.utfpr.td.tsi.projeto_delegacia.regras;

import java.util.List;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;

public interface IVeiculoService {
    
    public List<Veiculo> listVeiculos();

    public List<Veiculo> listVeiculos(IVeiculoFilter filter);

}
