package com.aleksey.crud_app.repository;

import java.util.List;

public interface GenericRepository<T, ID> {

    T getById(ID id);
    List<T> getAll();
    T create(T t);
    T update(T t);
    void deleteById(ID id);
}
