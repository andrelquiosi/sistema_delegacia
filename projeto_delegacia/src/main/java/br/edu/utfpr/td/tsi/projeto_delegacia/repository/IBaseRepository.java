package br.edu.utfpr.td.tsi.projeto_delegacia.repository;

import java.util.List;
import java.util.Optional;

public interface IBaseRepository<T, ID> {
    
    public T save(T entity);

    public List<T> saveAll(List<T> entities);

    public void deleteById(ID id);

    public Optional<T> findById(ID id);

    public List<T> findAll();
}
