package service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findOneById(long id);
    void save(T t);
    void delete(long id);
}
