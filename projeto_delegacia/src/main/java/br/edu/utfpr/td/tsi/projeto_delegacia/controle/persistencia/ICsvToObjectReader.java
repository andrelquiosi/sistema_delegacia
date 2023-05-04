package br.edu.utfpr.td.tsi.projeto_delegacia.controle.persistencia;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvException;

import br.edu.utfpr.td.tsi.projeto_delegacia.modelo.BoletimFurtoVeiculo;

public interface ICsvToObjectReader {

    public ArrayList<BoletimFurtoVeiculo> CsvBoletinsToObject(String csvFile)
            throws IOException, ParseException, CsvException;
}
