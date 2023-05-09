package br.edu.utfpr.td.tsi.projeto_delegacia.services;

import java.util.List;

import br.edu.utfpr.td.tsi.projeto_delegacia.model.Veiculo;

public interface IVeiculoService {
    
    public List<Veiculo> listVeiculos();

    public List<Veiculo> listVeiculos(IVeiculoFilter filter);

}
