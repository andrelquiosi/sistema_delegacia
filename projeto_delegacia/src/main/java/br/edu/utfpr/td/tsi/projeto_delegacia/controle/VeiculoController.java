package br.edu.utfpr.td.tsi.projeto_delegacia.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.persistencia.IBoletimFurtoVeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    
    @Autowired
    private IBoletimFurtoVeiculoRepository boletimFurtoVeiculoDAO;

    @GetMapping("/buscarPorPlaca{placa}")
    public List<Veiculo> listarVeiculosPorPlaca(@PathVariable(value="placa") String data ){
        // falta implementar a parte da filtragem de veiculos
        return boletimFurtoVeiculoDAO.buscarVeiculos(null);
    }
    
    @GetMapping("/buscarPorMarca{marca}")
    public List<Veiculo> listarVeiculosPorMarca(@PathVariable(value = "marca") String data) {
        // falta implementar a parte da filtragem de veiculos
        return boletimFurtoVeiculoDAO.buscarVeiculos(null);
    }

    @GetMapping
    public List<Veiculo> listarTodVeiculos(){
        return boletimFurtoVeiculoDAO.listarTodosVeiculos();
    }

    
}
