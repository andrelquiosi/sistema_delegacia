package br.edu.utfpr.td.tsi.projeto_delegacia.controle.persistencia;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;
import java.util.Date;
import java.util.List;

public interface BoletimFurtoVeiculoDAO {

    public void persistir(BoletimFurtoVeiculo boletimFurtoVeiculo);

    public List<BoletimFurtoVeiculo> listarTodosBoletim();

    public BoletimFurtoVeiculo buscarBoletimPorIdentificador(int identificador);

    public List<BoletimFurtoVeiculo> buscarBoletimPorData(Date dataOcorencia);

    public List<BoletimFurtoVeiculo> buscarBoletimPorCidade(String cidade);

    public List<Veiculo> listarTodosVeiculos();

    public List<Veiculo> buscarVeiculoPorPlaca(String placa);

    public List<Veiculo> buscarVeiculoPorMarca(String marca);
}
