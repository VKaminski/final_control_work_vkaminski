package com.gmail.kaminski.viktar.shop.repository;

public interface GenericRepository<I, T> {

    T findById(I id);

    void add(T entity);

    void delete(T entity);
}
