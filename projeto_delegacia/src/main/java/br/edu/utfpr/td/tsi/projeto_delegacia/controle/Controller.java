package br.edu.utfpr.td.tsi.projeto_delegacia.controle;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.td.tsi.projeto_delegacia.controle.persistencia.IBoletimFurtoVeiculoDAO;
import br.edu.utfpr.td.tsi.projeto_delegacia.exceptions.AlreadyExistsException;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;

@RestController
@RequestMapping("/projeto_delegacia")
public class Controller {

    @Autowired
    private IBoletimFurtoVeiculoDAO boletimFurtoVeiculoDAO;

    @GetMapping
    public ArrayList<BoletimFurtoVeiculo> listar() {
        return (ArrayList<BoletimFurtoVeiculo>) boletimFurtoVeiculoDAO.listarTodosBoletins();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoletimFurtoVeiculo cadastrarBoletim(@RequestBody BoletimFurtoVeiculo boletim) {

        try {
            boletimFurtoVeiculoDAO.adicionarBoletim(boletim);
        } catch (AlreadyExistsException e) {
            e.printStackTrace();
        }

        return boletim;
    }

}
