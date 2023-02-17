package com.gabit.school.daos;

import java.util.List;

public interface CRUD<T, K> {

    void create(T element);

    T readOne(K id);

    List<T> readAll();

    void update(T element);

    void delete(T element);

}
