package br.edu.utfpr.td.tsi.projeto_delegacia.controle.persistencia;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;
import java.util.Date;
import java.util.List;

public interface IBoletimFurtoVeiculoDAO {

    public void persistir(BoletimFurtoVeiculo boletimFurtoVeiculo);

    public List<BoletimFurtoVeiculo> listarTodosBoletim();

    public List<Veiculo> listarTodosVeiculos();

    public BoletimFurtoVeiculo buscarBoletimPorIdentificador(int idBoletimFurtoVeiculo);

    public List<BoletimFurtoVeiculo> buscarBoletimPorData(Date dataOcorencia);

    public List<BoletimFurtoVeiculo> buscarBoletimPorCidade(String cidade);

    // public List<Veiculo> buscarVeiculoPorPlaca(String placa);

    // public List<Veiculo> buscarVeiculoPorMarca(String marca);

    public List<Veiculo> buscarVeiculos(IFiltroVeiculo filtroVeiculo);

    public void alterarBoletim(int idBoletimFurtoVeiculo);

    public void removerBoletim(int idBoletimFurtoVeiculo);
}
