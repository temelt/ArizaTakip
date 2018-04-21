package com.temelt.arizatakip.service;

import java.util.List;

public interface IService<T> {

    final BaseService baseDao = new BaseService();

    boolean save(T entity) throws Exception;

    boolean update(T entity);

    boolean delete(T entity);

    List<T> getAll(String query);

    T getById(Long id);
}
