package com.company.pressRestApi.service;

import java.util.List;

public interface CrudService<T> {
    List<T> getAll();
    T getById (int id);
    boolean create (T t);
    boolean update (T t);
    boolean delete (T t);
}
