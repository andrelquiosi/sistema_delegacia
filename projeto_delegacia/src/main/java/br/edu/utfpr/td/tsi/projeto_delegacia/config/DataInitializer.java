package br.edu.utfpr.td.tsi.projeto_delegacia.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.projeto_delegacia.models.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.repositories.IBoletimFurtoVeiculoRepository;
import br.edu.utfpr.td.tsi.projeto_delegacia.repositories.ICSVConverter;
import br.edu.utfpr.td.tsi.projeto_delegacia.repositories.IVeiculoRepository;

@Component
public class DataInitializer implements ApplicationRunner {
    
    @Autowired
    private ICSVConverter<BoletimFurtoVeiculo> boletimCSVConverter;

    @Autowired
    private IBoletimFurtoVeiculoRepository boletimFurtoVeiculoRepository;

    @Autowired
    private IVeiculoRepository veiculoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String csvFile = "projeto_delegacia\\furtos.csv";
        
        List<BoletimFurtoVeiculo> boletins = boletimCSVConverter.convertFile(csvFile);
        List<Veiculo> veiculos = boletins.stream().map(BoletimFurtoVeiculo::getVeiculoFurtado).toList();
        
        boletimFurtoVeiculoRepository.saveAll(boletins);
        veiculoRepository.saveAll(veiculos);
    }
    
}
