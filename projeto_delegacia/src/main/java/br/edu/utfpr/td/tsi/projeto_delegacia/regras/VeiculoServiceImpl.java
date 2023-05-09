package br.edu.utfpr.td.tsi.projeto_delegacia.regras;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.persistencia.IVeiculoRepository;

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
        return veiculoRepository.save(veiculo);
    }
    
}
