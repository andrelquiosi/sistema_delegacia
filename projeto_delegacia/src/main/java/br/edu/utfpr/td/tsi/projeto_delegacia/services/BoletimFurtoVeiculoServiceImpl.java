package br.edu.utfpr.td.tsi.projeto_delegacia.services;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.BoletimNotFoundException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.DataOcorrenciaException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.NomeDaParteExeption;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.ParteEmailExeption;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.ParteTelefoneExeption;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.repositories.IBoletimFurtoVeiculoRepository;

@Service
public class BoletimFurtoVeiculoServiceImpl implements IBoletimFurtoVeiculoService {

    @Autowired
    private IBoletimFurtoVeiculoRepository boletimFurtoVeiculoRepository;
    @Autowired
    private IVeiculoService veiculoService;

    private static final String EMAIL_REGEX = "^[A-Z0-9+_.-]+@[A-Z0-9.-]+$";
    private static final String PHONE_REGEX = "^\\(\\d{2}\\) 9 \\d{4}-\\d{4}$";
    
    public static boolean isValidRegex(String valor, String validador) {
        Pattern pattern = Pattern.compile(validador);
        Matcher matcher = pattern.matcher(valor);
        return matcher.matches();
    }

    @Override
    public BoletimFurtoVeiculo createBoletim(BoletimFurtoVeiculo boletimFurtoVeiculo) {
        LocalDate hoje = LocalDate.now();

        if (boletimFurtoVeiculo.getDataOcorrencia() == null || boletimFurtoVeiculo.getDataOcorrencia().isAfter(hoje))
            throw new DataOcorrenciaException();
        
        if(boletimFurtoVeiculo.getParte().getNome() == null )
            throw new NomeDaParteExeption();

        if(isValidRegex(boletimFurtoVeiculo.getParte().getEmail(), EMAIL_REGEX))
            throw new ParteEmailExeption();
            
        if (isValidRegex(boletimFurtoVeiculo.getParte().getTelefone(), PHONE_REGEX))
            throw new ParteTelefoneExeption();
        
        
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
