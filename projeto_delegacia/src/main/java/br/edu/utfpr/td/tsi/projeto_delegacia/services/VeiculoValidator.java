package br.edu.utfpr.td.tsi.projeto_delegacia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.VeiculoAlreadyExists;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.VeiculoCorException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.VeiculoMarcaException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.VeiculoTipoVeiculoException;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.repositories.IVeiculoRepository;

@Component
public class VeiculoValidator implements IValidator<Veiculo> {

    @Autowired
    private IVeiculoRepository veiculoRepository;

    @Override
    public void validate(Veiculo veiculo) {
        if (veiculoRepository.existsById(veiculo.getIdVeiculo()))
            throw new VeiculoAlreadyExists();

        if (veiculo.getCor() == null)
            throw new VeiculoCorException();

        if (veiculo.getMarca() == null)
            throw new VeiculoMarcaException();

        if (veiculo.getTipoVeiculo() == null)
            throw new VeiculoTipoVeiculoException();
    }
    
}
