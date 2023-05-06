package br.edu.utfpr.td.tsi.projeto_delegacia.persistencia;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.regras.IFiltroBoletim;
import br.edu.utfpr.td.tsi.projeto_delegacia.regras.IFiltroVeiculo;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface IBoletimFurtoVeiculoRepository {

    public void save(BoletimFurtoVeiculo boletimFurtoVeiculo);

    public void update(String idBoletimFurtoVeiculo);

    public void deleteById(String idBoletimFurtoVeiculo);

    public BoletimFurtoVeiculo buscarBoletimPorId(String idBoletimFurtoVeiculo);

    public List<BoletimFurtoVeiculo> listarTodosBoletins();

    public List<Veiculo> listarTodosVeiculos();

    public List<BoletimFurtoVeiculo> buscarBoletins(IFiltroBoletim filtroBoletim);

    public List<Veiculo> buscarVeiculos(IFiltroVeiculo filtroVeiculo);

}
