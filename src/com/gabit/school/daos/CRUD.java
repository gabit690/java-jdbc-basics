package com.gabit.school.daos;

import java.util.List;

public interface CRUD<T, K> {

    void create(T element) throws DAOException;

    T readOne(K id) throws DAOException;

    List<T> readAll() throws DAOException;

    void update(T element) throws DAOException;

    void delete(T element) throws DAOException;

}
