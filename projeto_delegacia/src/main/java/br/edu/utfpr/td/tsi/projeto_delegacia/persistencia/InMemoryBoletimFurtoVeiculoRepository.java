package br.edu.utfpr.td.tsi.projeto_delegacia.persistencia;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.regras.IBoletimFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBoletimFurtoVeiculoRepository
        extends InMemoryRepository<BoletimFurtoVeiculo, String>
        implements IBoletimFurtoVeiculoRepository {

    private List<BoletimFurtoVeiculo> dataBase = new ArrayList<>();

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String getId(BoletimFurtoVeiculo entity) {
        return entity.getIdBoletimFurtoVeiculo();
    }

    @Override
    public void setId(BoletimFurtoVeiculo entity, String id) {
        entity.setIdBoletimFurtoVeiculo(id);
    }

    @Override
    public List<BoletimFurtoVeiculo> findAll(IBoletimFilter filter) {
        return dataBase.stream()
            .filter(boletim -> this.matchesFilter(boletim, filter))
            .toList();
    }

    private boolean matchesCidade(BoletimFurtoVeiculo boletim, IBoletimFilter filter) {
        return (
            filter.getCidade() != null &&
            boletim.getLocalOcorrencia().getCidade().equals(filter.getCidade())
        );
    }

    private boolean matchesPeriodoOcorrencia(BoletimFurtoVeiculo boletim, IBoletimFilter filter) {
        return (
            filter.getPeriodoOcorrencia() != null &&
            boletim.getPeriodoOcorrencia().equals(filter.getPeriodoOcorrencia())
        );
    }

    private boolean matchesFilter(BoletimFurtoVeiculo boletim, IBoletimFilter filter) {
        return matchesCidade(boletim, filter) || matchesPeriodoOcorrencia(boletim, filter);
    }

}
