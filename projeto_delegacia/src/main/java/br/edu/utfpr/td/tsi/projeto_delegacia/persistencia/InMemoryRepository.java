package br.edu.utfpr.td.tsi.projeto_delegacia.persistencia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class InMemoryRepository<T, ID> implements IBaseRepository<T, ID> {

    private List<T> dataBase = new ArrayList<>();

    @Override
    public T save(T entity) {
        Optional<T> entityOptional = findById(getId(entity));

        if (entityOptional.isPresent()) {
            int index = dataBase.indexOf(entityOptional.get());
            dataBase.set(index, entity);
        } else {
            setId(entity, generateId());
            dataBase.add(entity);
        }

        return entity;
    }

    @Override
    public List<T> saveAll(List<T> entities) {
        entities.forEach(this::save);
        return entities;
    }

    @Override
    public void deleteById(ID id) {
        dataBase.removeIf(entity -> getId(entity).equals(id));
    }

    @Override
    public List<T> findAll() {
        return Collections.unmodifiableList(dataBase);
    }

    @Override
    public Optional<T> findById(ID id) {
        return dataBase.stream()
            .filter(entity -> getId(entity).equals(id))
            .findFirst();
    }

    protected List<T> getDataBase() {
        return dataBase;
    }

    public abstract ID getId(T entity);
    public abstract void setId(T entity, ID id);
    public abstract ID generateId();
}
