package br.edu.utfpr.td.tsi.projeto_delegacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.BoletimNotFoundException;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.repositories.IBoletimFurtoVeiculoRepository;

@Service
public class BoletimFurtoVeiculoServiceImpl implements IBoletimFurtoVeiculoService {

    @Autowired
    private IBoletimFurtoVeiculoRepository boletimFurtoVeiculoRepository;
    @Autowired
    private IVeiculoService veiculoService;

    @Override
    public BoletimFurtoVeiculo createBoletim(BoletimFurtoVeiculo boletimFurtoVeiculo) {

        veiculoService.createVeiculo(boletimFurtoVeiculo.getVeiculoFurtado());

        return boletimFurtoVeiculoRepository.save(boletimFurtoVeiculo);
    }

    @Override
    public BoletimFurtoVeiculo readBoletim(String idBoletimFurtoVeiculo) {
        return boletimFurtoVeiculoRepository
            .findById(idBoletimFurtoVeiculo)
            .orElseThrow(BoletimNotFoundException::new);
    }

    @Override
    public BoletimFurtoVeiculo updateBoletim(String idBoletimFurtoVeiculo, BoletimFurtoVeiculo boletimFurtoVeiculo) {
        boletimFurtoVeiculo.setIdBoletimFurtoVeiculo(idBoletimFurtoVeiculo);

        if (!boletimFurtoVeiculoRepository.existsById(idBoletimFurtoVeiculo)) {
            throw new BoletimNotFoundException();
        }

        return boletimFurtoVeiculoRepository.save(boletimFurtoVeiculo);
    }

    @Override
    public void deleteBoletim(String idBoletimFurtoVeiculo) {
        boolean found = boletimFurtoVeiculoRepository.deleteById(idBoletimFurtoVeiculo);

        if (!found) {
            throw new BoletimNotFoundException();
        }
    }

    @Override
    public List<BoletimFurtoVeiculo> listBoletins() {
        return boletimFurtoVeiculoRepository.findAll();
    }

    @Override
    public List<BoletimFurtoVeiculo> listBoletins(IBoletimFilter filter) {
        return boletimFurtoVeiculoRepository.findAll(filter);
    }
    
}
