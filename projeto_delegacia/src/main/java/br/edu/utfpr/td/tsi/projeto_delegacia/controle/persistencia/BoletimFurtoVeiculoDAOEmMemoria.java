package br.edu.utfpr.td.tsi.projeto_delegacia.controle.persistencia;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class BoletimFurtoVeiculoDAOEmMemoria implements IBoletimFurtoVeiculoDAO {

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
        return dataBase.stream()
            .filter(boletim -> boletim.getIdBoletimFurtoVeiculo() == identificador)
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<BoletimFurtoVeiculo> buscarBoletimPorData(Date dataOcorrencia) {
        return dataBase.stream()
            .filter(boletim -> boletim.getDataOcorrencia().equals(dataOcorrencia))
            .toList();
    }

    @Override
    public List<BoletimFurtoVeiculo> buscarBoletimPorCidade(String cidade) {
        return dataBase.stream()
            .filter(boletim -> boletim.getLocalOcorrencia().getCidade().equals(cidade))
            .toList();
    }

    @Override
    public List<Veiculo> listarTodosVeiculos() {
        return null;
    }

    @Override
    public List<Veiculo> buscarVeiculos(IFiltroVeiculo filtroVeiculo) {
        return dataBase.stream()
            .map(BoletimFurtoVeiculo::getVeiculoFurtado)
            .filter(veiculo ->
                veiculo.getMarca().equals(filtroVeiculo.getMarca()) ||
                veiculo.getEmplacamento().getPlaca().equals(filtroVeiculo.getPlaca()))
            .toList();
    }
    

    @Override
    public void alterarBoletim(int idBoletimFurtoVeiculo) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removerBoletim(int idBoletimFurtoVeiculo) {
        // TODO Auto-generated method stub
        
    }

}
