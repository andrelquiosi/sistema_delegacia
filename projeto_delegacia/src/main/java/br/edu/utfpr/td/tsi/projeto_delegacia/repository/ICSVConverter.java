package br.edu.utfpr.td.tsi.projeto_delegacia.repository;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.opencsv.exceptions.CsvException;

public interface ICSVConverter<T> {

    public List<T> convertFile(String csvFile) throws IOException, ParseException, CsvException;

}
