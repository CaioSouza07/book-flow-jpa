package com.dao;

import java.util.List;

public interface BaseDAO <T>{

    public void salvar(T entity);
    public T buscarPorId(Class<T> entityClass, Long id);
    public void deletar(T entity);
    public void atualizar(T entity);

}
