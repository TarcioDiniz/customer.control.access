package com.customer.control.access.domain.repositories.base;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IBaseRepository<T, ID extends Serializable> {

    T save(T entity);

    T update(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    void delete(T entity);

    void deleteById(ID id);

}
