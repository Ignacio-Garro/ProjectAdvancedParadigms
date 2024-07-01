package hr.algebra.studentprojectapiinteropability.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {

    //has a default method execute which accepts a ServiceExecutor

    List<T> getAll();

    Optional<T> getById(Long id);

    void add(T entity);

    void update(Long id, T entity);

    void delete(Long id);

    default void execute(ServiceExecutor<BaseService<T>> executor) {
        executor.execute(this);
    }
}

