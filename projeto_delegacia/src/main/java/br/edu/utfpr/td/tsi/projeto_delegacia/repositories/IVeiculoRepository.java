package br.edu.utfpr.td.tsi.projeto_delegacia.repositories;

import java.util.List;

import br.edu.utfpr.td.tsi.projeto_delegacia.models.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.services.IVeiculoFilter;

public interface IVeiculoRepository extends IBaseRepository<Veiculo, String> {

    public List<Veiculo> findAll(IVeiculoFilter veiculoFilter);

}
