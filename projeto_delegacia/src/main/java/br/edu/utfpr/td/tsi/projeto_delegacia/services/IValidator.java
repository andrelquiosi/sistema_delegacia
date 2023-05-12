package br.edu.utfpr.td.tsi.projeto_delegacia.services;

public interface IValidator<T> {
    
    public void validate(T entity);

}
