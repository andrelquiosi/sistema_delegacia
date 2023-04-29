package br.edu.utfpr.td.tsi.projeto_delegacia.controle.persistencia;

import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.AlreadyExistsException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.NotFoundException;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;
import java.util.ArrayList;
import java.util.List;

public class BoletimFurtoVeiculoDAOEmMemoria implements IBoletimFurtoVeiculoDAO {

    private ArrayList<BoletimFurtoVeiculo> dataBase = new ArrayList<>();

    @Override
    public void adicionarBoletim(BoletimFurtoVeiculo boletimFurtoVeiculo) throws AlreadyExistsException {
        boolean alreadyExists = dataBase.stream()
                .anyMatch(b -> b.getIdBoletimFurtoVeiculo() == boletimFurtoVeiculo.getIdBoletimFurtoVeiculo());

        if (alreadyExists) {
            throw new AlreadyExistsException();
        }

        dataBase.add(boletimFurtoVeiculo);
    }

    @Override
    public void alterarBoletim(Long idBoletimFurtoVeiculo, BoletimFurtoVeiculo boletimFurtoVeiculo)
            throws NotFoundException {
        BoletimFurtoVeiculo boletim = buscarBoletimPorId(idBoletimFurtoVeiculo);
        int index = dataBase.indexOf(boletim);

        dataBase.set(index, boletimFurtoVeiculo);
    }

    @Override
    public void removerBoletim(Long idBoletimFurtoVeiculo) throws NotFoundException {
        BoletimFurtoVeiculo boletim = buscarBoletimPorId(idBoletimFurtoVeiculo);
        dataBase.remove(boletim);
    }

    @Override
    public BoletimFurtoVeiculo buscarBoletimPorId(Long idBoletimFurtoVeiculo)
            throws NotFoundException {

        return dataBase.stream()
            .filter(boletim -> boletim.getIdBoletimFurtoVeiculo() == idBoletimFurtoVeiculo)
            .findFirst()
            .orElseThrow(() -> new NotFoundException());
    }

    @Override
    public List<BoletimFurtoVeiculo> listarTodosBoletins() {
        return dataBase;
    }

    @Override
    public List<Veiculo> listarTodosVeiculos() {
        return dataBase.stream().map(BoletimFurtoVeiculo::getVeiculoFurtado).toList();
    }

    @Override
    public List<BoletimFurtoVeiculo> buscarBoletins(IFiltroBoletim filtroBoletim) {
        return dataBase.stream()
            .filter(boletim ->
                boletim.getLocalOcorrencia().getCidade().equals(filtroBoletim.getCidade()) ||
                boletim.getDataOcorrencia().equals(filtroBoletim.getDataOcorrencia()))
            .toList();
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
    
}
