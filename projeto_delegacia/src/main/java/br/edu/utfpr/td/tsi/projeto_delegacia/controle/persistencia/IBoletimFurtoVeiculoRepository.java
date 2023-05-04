package br.edu.utfpr.td.tsi.projeto_delegacia.controle.persistencia;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface IBoletimFurtoVeiculoRepository {

    public void save(BoletimFurtoVeiculo boletimFurtoVeiculo);

    public void update(BoletimFurtoVeiculo boletimFurtoVeiculo);

    public void deleteById(Long idBoletimFurtoVeiculo);

    public BoletimFurtoVeiculo buscarBoletimPorId(Long idBoletimFurtoVeiculo);

    public List<BoletimFurtoVeiculo> listarTodosBoletins();

    public List<Veiculo> listarTodosVeiculos();

    public List<BoletimFurtoVeiculo> buscarBoletins(IFiltroBoletim filtroBoletim);

    public List<Veiculo> buscarVeiculos(IFiltroVeiculo filtroVeiculo);

}
