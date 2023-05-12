package br.edu.utfpr.td.tsi.projeto_delegacia.services;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.DataOcorrenciaException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.EnderecoCidadeExeption;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.EnderecoEstadoExeption;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.NomeDaParteExeption;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.ParteEmailExeption;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.ParteTelefoneExeption;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.VeiculoCorExeption;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.VeiculoMarcaExeption;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.utils.ValidationUtils;

@Component
public class BoletimValidator implements IValidator<BoletimFurtoVeiculo> {

    @Override
    public void validate(BoletimFurtoVeiculo boletimFurtoVeiculo) {

        if (boletimFurtoVeiculo.getDataOcorrencia() == null ||
            boletimFurtoVeiculo.getDataOcorrencia().isAfter(LocalDate.now()))
            throw new DataOcorrenciaException();

        if (boletimFurtoVeiculo.getParte().getNome() == null)
            throw new NomeDaParteExeption();

        if (!ValidationUtils.isEmailValid(boletimFurtoVeiculo.getParte().getEmail()))
            throw new ParteEmailExeption();

        if (!ValidationUtils.isPhoneValid(boletimFurtoVeiculo.getParte().getTelefone()))
            throw new ParteTelefoneExeption();

        if (boletimFurtoVeiculo.getLocalOcorrencia().getCidade() == null)
            throw new EnderecoCidadeExeption();

        if (boletimFurtoVeiculo.getLocalOcorrencia().getEstado() == null)
            throw new EnderecoEstadoExeption();

        if (boletimFurtoVeiculo.getVeiculoFurtado().getCor() == null)
            throw new VeiculoCorExeption();

        if (boletimFurtoVeiculo.getVeiculoFurtado().getMarca() == null)
            throw new VeiculoMarcaExeption();

    }
    
}
