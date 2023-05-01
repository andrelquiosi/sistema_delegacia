package br.edu.utfpr.td.tsi.projeto_delegacia.controle.persistencia;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Emplacamento;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Endereco;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Parte;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;

public class CsvToObjectReader {

    public ArrayList<BoletimFurtoVeiculo> readBoletimFromCSV(String csvFile) throws IOException, ParseException, CsvException {

        ArrayList<BoletimFurtoVeiculo> boletimBoletimFurtoVeiculos = new ArrayList<>();

        CSVReader reader = new CSVReaderBuilder(new FileReader(csvFile))
                .withCSVParser(new CSVParserBuilder().withSeparator('\t').build())
                .build();

        reader.readNext();
        List<String[]> lines = reader.readAll();

        for (String[] line : lines) {
            BoletimFurtoVeiculo boletim = new BoletimFurtoVeiculo();

            boletim.setIdBoletimFurtoVeiculo(Long.parseLong(line[1]));
            boletim.setDataOcorrencia(dateFormated(line[5] + " " + line[6]));
            boletim.setPeriodoOcorrencia(line[7]);
            boletim.setParte(createParte(null, null, null, line[29]));
            boletim.setLocalOcorrencia(createLocalOcorrencia(line[13], line[14], line[15], line[16], line[17]));
            boletim.setVeiculoFurtado(createVeiculoFurto(line[49], line[47], line[48], line[51],
                    createEmplacamento(line[44], line[45], line[46])));

            System.out.println(boletim);
            boletimBoletimFurtoVeiculos.add(boletim);
        }

        reader.close();
        return boletimBoletimFurtoVeiculos;
    }

    private Date dateFormated(String data) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse(data);

        return date;

    }

    private Emplacamento createEmplacamento(
            String placa,
            String estado,
            String cidade) {

        Emplacamento emplacamento = new Emplacamento();

        emplacamento.setPlaca(placa);
        emplacamento.setEstado(estado);
        emplacamento.setCidade(cidade);

        return emplacamento;

    }

    private Veiculo createVeiculoFurto(
            String anoFabricacao,
            String cor,
            String marca,
            String tipoVeiculo,
            Emplacamento emplacamento) {

        Veiculo veiculo = new Veiculo();
        if (!anoFabricacao.isEmpty())
            veiculo.setAnoFabricacao(Integer.parseInt(anoFabricacao));
        else
            veiculo.setAnoFabricacao(0);

        veiculo.setCor(cor);
        veiculo.setMarca(marca);
        veiculo.setTipoVeiculo(tipoVeiculo);
        veiculo.setEmplacamento(emplacamento);

        return veiculo;

    }

    private Endereco createLocalOcorrencia(
            String logradouro,
            String numero,
            String bairro,
            String cidade,
            String estado) {

        Endereco endereco = new Endereco();

        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);

        return endereco;
    }

    private Parte createParte(
            String email,
            String nome,
            String telefone,
            String tipoEnvolvimento) {

        Parte parte = new Parte();

        parte.setEmail(email);
        parte.setNome(nome);
        parte.setTelefone(telefone);
        parte.setTipoEnvolvimento(tipoEnvolvimento);

        return parte;
    }

    // public static void main(String[] args) throws IOException, ParseException, CsvException {
    //     CsvToObjectReader csv = new CsvToObjectReader();
    //     csv.readBoletimFromCSV("projeto_delegacia/furtos.csv");
    // }
}
