package br.edu.utfpr.td.tsi.projeto_delegacia.repository;

import br.edu.utfpr.td.tsi.projeto_delegacia.model.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.rules.IBoletimFilter;

import java.util.List;

public interface IBoletimFurtoVeiculoRepository extends IBaseRepository<BoletimFurtoVeiculo, String> {

    public List<BoletimFurtoVeiculo> findAll(IBoletimFilter boletimFilter);

}