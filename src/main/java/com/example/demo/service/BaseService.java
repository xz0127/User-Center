package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BaseService<T, ID> {
    /**
     * Save single entity
     *
     * @param entity
     * @param <S>
     * @return
     */
    <S extends T> S save(S entity);

    /**
     * Save all entities
     *
     * @param entities
     * @param <S>
     * @return
     */
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    /**
     * Get object based on id
     *
     * @param id
     * @return
     */
    Optional<T> findById(ID id);

    /**
     * check if an object exists
     *
     * @param id
     * @return
     */
    boolean existsById(ID id);

    /**
     * get all entities
     *
     * @return
     */
    Iterable<T> findAll();

    /**
     * find all objects by id
     *
     * @param ids
     * @return
     */
    Iterable<T> findAllById(Iterable<ID> ids);

    /**
     * find by pages
     *
     * @param pageable
     * @return
     */
    Page<T> findAll(Pageable pageable);

    /**
     * @return number of rows
     */
    Long count();

    /**
     * delete entity based on id
     *
     * @param id
     */
    void deleteById(ID id);

    /**
     * delete entity
     *
     * @param entity
     */
    void delete(T entity);

    /**
     * delete all entities
     *
     * @param entities
     */
    void deleteAll(Iterable<? extends T> entities);
}
