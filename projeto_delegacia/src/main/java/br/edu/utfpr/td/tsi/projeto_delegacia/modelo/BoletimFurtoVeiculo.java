package br.edu.utfpr.td.tsi.projeto_delegacia.modelo;

import java.util.Date;

public class BoletimFurtoVeiculo {

    private int identificador;
    private Date dataOcorencia;
    private String periodoOcorencia;
    private Parte parte;
    private Endereco localOcorencia;
    private Veiculo veiculoFurtado;

    public BoletimFurtoVeiculo(int identificador, Date dataOcorencia, String periodoOcorencia, Parte parte,
            Endereco localOcorencia, Veiculo veiculoFurtado) {
        this.identificador = identificador;
        this.dataOcorencia = dataOcorencia;
        this.periodoOcorencia = periodoOcorencia;
        this.parte = parte;
        this.localOcorencia = localOcorencia;
        this.veiculoFurtado = veiculoFurtado;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Date getDataOcorencia() {
        return dataOcorencia;
    }

    public void setDataOcorencia(Date dataOcorencia) {
        this.dataOcorencia = dataOcorencia;
    }

    public String getPeriodoOcorencia() {
        return periodoOcorencia;
    }

    public void getPeriodoOcorencia(String periodoOcorencia) {
        this.periodoOcorencia = periodoOcorencia;
    }

    public Parte getParte() {
        return parte;
    }

    public void setParte(Parte parte) {
        this.parte = parte;
    }

    public Endereco getLocalOcorencia() {
        return localOcorencia;
    }

    public void setLocalOcorencia(Endereco localOcorencia) {
        this.localOcorencia = localOcorencia;
    }

    public Veiculo getVeiculoFurtado() {
        return veiculoFurtado;
    }

    public void setVeiculoFurtado(Veiculo veiculoFurtado) {
        this.veiculoFurtado = veiculoFurtado;
    }

}
