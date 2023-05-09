package br.edu.utfpr.td.tsi.projeto_delegacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.projeto_delegacia.model.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.repository.IBoletimFurtoVeiculoRepository;
import br.edu.utfpr.td.tsi.projeto_delegacia.repository.IVeiculoRepository;

@Service
public class BoletimFurtoVeiculoServiceImpl implements IBoletimFurtoVeiculoService {

    @Autowired
    private IBoletimFurtoVeiculoRepository boletimFurtoVeiculoRepository;
    @Autowired
    private IVeiculoRepository veiculoRepository;

    @Override
    public BoletimFurtoVeiculo createBoletim(BoletimFurtoVeiculo boletimFurtoVeiculo) {
        veiculoRepository.save(boletimFurtoVeiculo.getVeiculoFurtado());
        return boletimFurtoVeiculoRepository.save(boletimFurtoVeiculo);
    }

    @Override
    public BoletimFurtoVeiculo readBoletim(String idBoletimFurtoVeiculo) {
        return boletimFurtoVeiculoRepository.findById(idBoletimFurtoVeiculo).orElseThrow();
    }

    @Override
    public BoletimFurtoVeiculo updateBoletim(String idBoletimFurtoVeiculo, BoletimFurtoVeiculo boletimFurtoVeiculo) {
        boletimFurtoVeiculo.setIdBoletimFurtoVeiculo(idBoletimFurtoVeiculo);
        return boletimFurtoVeiculoRepository.save(boletimFurtoVeiculo);
    }

    @Override
    public void deleteBoletim(String idBoletimFurtoVeiculo) {
        boletimFurtoVeiculoRepository.deleteById(idBoletimFurtoVeiculo);
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
