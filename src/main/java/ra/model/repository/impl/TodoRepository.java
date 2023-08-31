package ra.model.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.model.entity.Todo;
import ra.model.repository.ITodoRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TodoRepository implements ITodoRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Todo> findAll() {
        return entityManager.createQuery("Select T From Todo as T", Todo.class)
                .getResultList();
    }

    @Override
    public Todo findById(Long id) {
        return entityManager.createQuery("Select T From Todo as T where T.id= :id", Todo.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void save(Todo p) {
        if (p.getId() != null) {
            entityManager.persist(p);
        } else {
            entityManager.merge(p);
        }
    }

    @Override
    public void delete(Long aLong) {
        entityManager.remove(findById(aLong));
    }
}
