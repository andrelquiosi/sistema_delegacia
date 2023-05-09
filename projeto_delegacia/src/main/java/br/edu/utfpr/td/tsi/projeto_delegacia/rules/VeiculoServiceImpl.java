package br.edu.utfpr.td.tsi.projeto_delegacia.rules;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.projeto_delegacia.model.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.repository.IVeiculoRepository;

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
    
}
