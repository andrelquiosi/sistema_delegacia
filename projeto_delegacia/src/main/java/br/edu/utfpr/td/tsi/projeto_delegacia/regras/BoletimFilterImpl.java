package br.edu.utfpr.td.tsi.projeto_delegacia.regras;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.PeriodoOcorrencia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletimFilterImpl implements IBoletimFilter {
    private String cidade;
    private PeriodoOcorrencia periodoOcorrencia;
}
