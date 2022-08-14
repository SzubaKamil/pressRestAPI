package com.company.pressRestApi.dao;

import java.util.List;

public interface CrudDAO<T> {
    List<T> getAll();
    T getById (int id);
    boolean create (T t);
    boolean update (T t);
    boolean delete (T t);
}
