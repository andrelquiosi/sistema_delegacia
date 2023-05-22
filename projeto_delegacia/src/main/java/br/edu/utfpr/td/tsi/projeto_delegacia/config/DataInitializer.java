package br.edu.utfpr.td.tsi.projeto_delegacia.config;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.projeto_delegacia.dtos.BoletimFurtoVeiculoDTO;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.repositories.IBoletimFurtoVeiculoRepository;
import br.edu.utfpr.td.tsi.projeto_delegacia.repositories.ICSVConverter;
import br.edu.utfpr.td.tsi.projeto_delegacia.repositories.IVeiculoRepository;

@Component
public class DataInitializer implements ApplicationRunner {
    
    @Autowired
    private ICSVConverter<BoletimFurtoVeiculoDTO> boletimCSVConverter;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IBoletimFurtoVeiculoRepository boletimFurtoVeiculoRepository;
    @Autowired
    private IVeiculoRepository veiculoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileInputStream file = new FileInputStream("furtos.csv");
        InputStream csvFileStream = new BufferedInputStream(file);
        
        List<BoletimFurtoVeiculoDTO> boletinsDTO = boletimCSVConverter.convertFileStream(csvFileStream);

        boletinsDTO.forEach(boletimDTO -> {
            Veiculo veiculo = veiculoRepository.save(boletimDTO.getVeiculoFurtado());
            
            BoletimFurtoVeiculo boletim = modelMapper.map(boletimDTO, BoletimFurtoVeiculo.class);
            boletim.setIdVeiculoFurtado(veiculo.getIdVeiculo());

            boletimFurtoVeiculoRepository.save(boletim);
        });
    }
    
}
