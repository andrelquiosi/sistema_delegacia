package br.edu.utfpr.td.tsi.projeto_delegacia.controle.persistencia;

import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.AlreadyExistsException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.NotFoundException;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;

import java.util.List;

public interface IBoletimFurtoVeiculoDAO {

    public void adicionarBoletim(BoletimFurtoVeiculo boletimFurtoVeiculo) throws AlreadyExistsException;

    public void alterarBoletim(Long idBoletimFurtoVeiculo, BoletimFurtoVeiculo boletimFurtoVeiculo)
            throws NotFoundException;

    public void removerBoletim(Long idBoletimFurtoVeiculo) throws NotFoundException;

    public BoletimFurtoVeiculo buscarBoletimPorId(Long idBoletimFurtoVeiculo)
            throws NotFoundException;

    public List<BoletimFurtoVeiculo> listarTodosBoletins();

    public List<Veiculo> listarTodosVeiculos();

    public List<BoletimFurtoVeiculo> buscarBoletins(IFiltroBoletim filtroBoletim);

    public List<Veiculo> buscarVeiculos(IFiltroVeiculo filtroVeiculo);

}
