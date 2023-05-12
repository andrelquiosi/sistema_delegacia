package br.edu.utfpr.td.tsi.projeto_delegacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.VeiculoAlreadyExists;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.VeiculoCorException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.VeiculoMarcaException;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.VeiculoTipoVeiculoException;
import br.edu.utfpr.td.tsi.projeto_delegacia.models.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.repositories.IVeiculoRepository;

@Service
public class VeiculoServiceImpl implements IVeiculoService {

    @Autowired
    private IVeiculoRepository veiculoRepository;

    @Override
    public List<Veiculo> listVeiculos() {
        return veiculoRepository.findAll();
    }

    @Override
    public List<Veiculo> listVeiculos(IVeiculoFilter filter) {
        return veiculoRepository.findAll(filter);
    }

    @Override
    public Veiculo createVeiculo(Veiculo veiculo) {

        if (veiculoRepository.existsById(veiculo.getIdVeiculo()))
            throw new VeiculoAlreadyExists();

        if (veiculo.getCor() == null)
            throw new VeiculoCorException();

        if (veiculo.getMarca() == null)
            throw new VeiculoMarcaException();

        if (veiculo.getTipoVeiculo() == null)
            throw new VeiculoTipoVeiculoException();

        return veiculoRepository.save(veiculo);
    }
    
}
