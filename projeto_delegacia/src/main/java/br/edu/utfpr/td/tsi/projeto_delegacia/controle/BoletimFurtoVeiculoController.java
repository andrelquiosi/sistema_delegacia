package br.edu.utfpr.td.tsi.projeto_delegacia.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.persistencia.IBoletimFurtoVeiculoRepository;

@RestController
@RequestMapping("/boletins")
public class BoletimFurtoVeiculoController {

    @Autowired
    private IBoletimFurtoVeiculoRepository boletimFurtoVeiculoDAO;

    @GetMapping
    public List<BoletimFurtoVeiculo> listarTodosBoletins() {
        return boletimFurtoVeiculoDAO.listarTodosBoletins();
    }

    @GetMapping("/boletim")
    public BoletimFurtoVeiculo buscarBoletimPorId(
            @RequestParam(value = "id", required = true) String idBoletimFurtoVeiculo) {
        return boletimFurtoVeiculoDAO.buscarBoletimPorId(idBoletimFurtoVeiculo);
    }

    @GetMapping("/cidade")
    public List<BoletimFurtoVeiculo> buscarBoletinsPorCidade(
            @RequestParam(value = "id", required = true) String idBoletimFurtoVeiculo) {

        // precisa implementar o filter para os boletins
        return boletimFurtoVeiculoDAO.buscarBoletins(null);
    }

    @GetMapping("/data")
    public List<BoletimFurtoVeiculo> buscarBoletinsPorData(
            @RequestParam(value = "data", required = true) String dataBoletimFurtoVeiculo) {

        // precisa implementar o filter para os boletins
        return boletimFurtoVeiculoDAO.buscarBoletins(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoletimFurtoVeiculo cadastrarBoletim(@RequestBody BoletimFurtoVeiculo boletim) {

        boletimFurtoVeiculoDAO.save(boletim);

        return boletim;
    }

    @PutMapping("/boletim/alterar")
    public void alteraBoletimPorId(@RequestParam(value = "id", required = true) String idBoletimFurtoVeiculo) {
        boletimFurtoVeiculoDAO.update(null);
    }

    @DeleteMapping("/boletim/remover")
    public void removerBoletimPorId(@RequestParam(value = "id", required = true) String idBoletimFurtoVeiculo) {
        boletimFurtoVeiculoDAO.deleteById(idBoletimFurtoVeiculo);

    }

}
