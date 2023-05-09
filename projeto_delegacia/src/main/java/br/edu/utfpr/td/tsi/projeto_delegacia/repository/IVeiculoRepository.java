package br.edu.utfpr.td.tsi.projeto_delegacia.repository;

import java.util.List;

import br.edu.utfpr.td.tsi.projeto_delegacia.model.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.rules.IVeiculoFilter;

public interface IVeiculoRepository extends IBaseRepository<Veiculo, String> {

    public List<Veiculo> findAll(IVeiculoFilter veiculoFilter);

}
