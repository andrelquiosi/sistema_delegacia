package br.edu.utfpr.td.tsi.projeto_delegacia.persistencia;

import java.util.List;


import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.regras.IVeiculoFilter;

public interface IVeiculoRepository extends IBaseRepository<Veiculo, String> {

    public List<Veiculo> findAll(IVeiculoFilter veiculoFilter);

}
