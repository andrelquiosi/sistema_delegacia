package br.edu.utfpr.td.tsi.projeto_delegacia.persistencia;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.opencsv.exceptions.CsvException;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;

@Component
public interface ICsvToObjectReader {

    public ArrayList<BoletimFurtoVeiculo> CsvBoletinsToObject(String csvFile)
            throws IOException, ParseException, CsvException;
}
