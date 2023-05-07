package br.edu.utfpr.td.tsi.projeto_delegacia.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.PeriodoOcorrencia;
import br.edu.utfpr.td.tsi.projeto_delegacia.regras.BoletimFilterImpl;
import br.edu.utfpr.td.tsi.projeto_delegacia.regras.IBoletimFilter;
import br.edu.utfpr.td.tsi.projeto_delegacia.regras.IBoletimFurtoVeiculoService;

@RestController
@RequestMapping("/boletins")
public class BoletimFurtoVeiculoController {

    @Autowired
    private IBoletimFurtoVeiculoService boletimFurtoVeiculoService;

    @GetMapping
    public List<BoletimFurtoVeiculo> listBoletins(
        @RequestParam(name = "cidade", required = false) String cidade,
        @RequestParam(name = "periodo", required = false) PeriodoOcorrencia periodo 
    ) {
        if (cidade == null && periodo == null) {
            return boletimFurtoVeiculoService.listBoletins();
        }

        IBoletimFilter filter = new BoletimFilterImpl(cidade, periodo);
        return boletimFurtoVeiculoService.listBoletins(filter);
    }

    @GetMapping("/{id}")
    public BoletimFurtoVeiculo buscarBoletimPorId(@PathVariable("id") String idBoletimFurtoVeiculo) {
        return boletimFurtoVeiculoService.readBoletim(idBoletimFurtoVeiculo);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public BoletimFurtoVeiculo cadastrarBoletim(@RequestBody BoletimFurtoVeiculo boletim) {
        return boletimFurtoVeiculoService.createBoletim(boletim);
    }

    @PutMapping("/{id}")
    public BoletimFurtoVeiculo updateBoletimById(
        @PathVariable("id") String idBoletimFurtoVeiculo,
        @RequestBody BoletimFurtoVeiculo boletim
    ) {
        return boletimFurtoVeiculoService.updateBoletim(idBoletimFurtoVeiculo, boletim);
    }

    @DeleteMapping("/{id}")
    public void deleteBoletimById(@PathVariable("id") String idBoletimFurtoVeiculo) {
        boletimFurtoVeiculoService.deleteBoletim(idBoletimFurtoVeiculo);
    }

}
