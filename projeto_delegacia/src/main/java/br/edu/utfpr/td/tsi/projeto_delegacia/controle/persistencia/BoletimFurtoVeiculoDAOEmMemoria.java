package br.edu.utfpr.td.tsi.projeto_delegacia.controle.persistencia;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class BoletimFurtoVeiculoDAOEmMemoria implements BoletimFurtoVeiculoDAO {

    private ArrayList<BoletimFurtoVeiculo> dataBase = new ArrayList<>();

    @Override
    public void persistir(BoletimFurtoVeiculo boletimFurtoVeiculo) {

        dataBase.add(boletimFurtoVeiculo);

    }

    @Override
    public List<BoletimFurtoVeiculo> listarTodosBoletim() {

        return dataBase;
    }

    @Override
    public BoletimFurtoVeiculo buscarBoletimPorIdentificador(int identificador) {
        return null;

    }

    @Override
    public List<BoletimFurtoVeiculo> buscarBoletimPorData(Date dataOcorencia) {
        return dataBase;
    }

    @Override
    public List<BoletimFurtoVeiculo> buscarBoletimPorCidade(String cidade) {
        return dataBase;
    }

    @Override
    public List<Veiculo> listarTodosVeiculos() {
        return null;
    }

    @Override
    public List<Veiculo> buscarVeiculoPorPlaca(String placa) {
        return null;
    }

    @Override
    public List<Veiculo> buscarVeiculoPorMarca(String marca) {
        return null;
    }

}
