package br.edu.utfpr.td.tsi.projeto_delegacia.persistencia;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.regras.IBoletimFilter;

import java.util.List;

public interface IBoletimFurtoVeiculoRepository extends IBaseRepository<BoletimFurtoVeiculo, String> {

    public List<BoletimFurtoVeiculo> findAll(IBoletimFilter boletimFilter);

}