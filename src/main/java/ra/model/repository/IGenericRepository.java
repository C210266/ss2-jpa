package ra.model.repository;

import java.util.List;

public interface IGenericRepository <T,E>{
    List<T> findAll();
    T findById(E e);
    void save(T t);
    void delete(E e);
}
