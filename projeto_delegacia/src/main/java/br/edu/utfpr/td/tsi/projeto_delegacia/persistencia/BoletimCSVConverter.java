package br.edu.utfpr.td.tsi.projeto_delegacia.persistencia;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Emplacamento;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Endereco;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Parte;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.PeriodoOcorrencia;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.TipoVeiculo;
import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.Veiculo;

@Component
public class BoletimCSVConverter implements ICSVConverter<BoletimFurtoVeiculo> {

    public List<BoletimFurtoVeiculo> convertFile(String csvFile) throws IOException, ParseException, CsvException {

        List<String[]> lines = readFile(csvFile);

        List<BoletimFurtoVeiculo> boletins = new ArrayList<>();

        for (String[] line : lines) {
            BoletimFurtoVeiculo boletim = convertLine(line);
            boletins.add(boletim);
        }

        return boletins;
    }

    private List<String[]> readFile(String csvFile) throws IOException, ParseException, CsvException {

        CSVParser csvParser = new CSVParserBuilder()
            .withSeparator('\t')
            .build();

        CSVReader reader = new CSVReaderBuilder(new FileReader(csvFile))
            .withCSVParser(csvParser)
            .build();

        reader.readNext();

        List<String[]> lines = reader.readAll();

        reader.close();

        return lines;
    }

    private BoletimFurtoVeiculo convertLine(String[] line) throws ParseException {
        BoletimFurtoVeiculo boletim = new BoletimFurtoVeiculo();


        Date dataOcorrencia = formatDate(line[5]);
        PeriodoOcorrencia periodoOcorrencia = PeriodoOcorrencia.fromDescription(line[7]);
        Parte parte = createParteFromLine(line);
        Endereco localOcorrencia = createLocalOcorrenciaFromLine(line);
        Veiculo veiculoFurtado = createVeiculoFromLine(line);
        
        boletim.setDataOcorrencia(dataOcorrencia);
        boletim.setLocalOcorrencia(localOcorrencia);
        boletim.setParte(parte);
        boletim.setPeriodoOcorrencia(periodoOcorrencia);
        boletim.setVeiculoFurtado(veiculoFurtado);

        return boletim;
    }

    private Date formatDate(String data) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse(data);

        return date;
    }

    private Parte createParteFromLine(String[] line) {
        Parte parte = new Parte();

        parte.setTipoEnvolvimento(line[29]);

        return parte;
    }

    private Endereco createLocalOcorrenciaFromLine(String[] line) {
        Endereco endereco = new Endereco();

        endereco.setLogradouro(line[13]);
        endereco.setNumero(line[14]);
        endereco.setBairro(line[15]);
        endereco.setCidade(line[16]);
        endereco.setEstado(line[17]);

        return endereco;
    }

    private Veiculo createVeiculoFromLine(String[] line) {
        Veiculo veiculo = new Veiculo();

        Integer anoFabricacao = null;

        if (!line[49].isEmpty()) {
            anoFabricacao = Integer.parseInt(line[49]);
        }

        veiculo.setAnoFabricacao(anoFabricacao);
        veiculo.setCor(line[47]);
        veiculo.setMarca(line[48]);
        veiculo.setTipoVeiculo(TipoVeiculo.fromDescription(line[51]));
        veiculo.setEmplacamento(createEmplacamentoFromLine(line));

        return veiculo;
    }

    private Emplacamento createEmplacamentoFromLine(String[] line) {
        Emplacamento emplacamento = new Emplacamento();

        emplacamento.setPlaca(line[44]);
        emplacamento.setEstado(line[45]);
        emplacamento.setCidade(line[46]);

        return emplacamento;
    }

}
