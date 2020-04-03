package web.dao;
/*
 *
 *@Data 24.02.2020
 *@autor Fedorov Yuri
 *@project spring_hibernate
 *
 */


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.config.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void add(User model) {
        entityManager.persist(model);
    }

    @Transactional
    @Override
    public void update(User model) {
        entityManager.merge(model);
    }

    @Transactional(readOnly = true)
    @Override
    public User findModelByName(String email) {
        Query query = entityManager.createQuery("SELECT u FROM User u where u.email = :email");
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    @Transactional()
    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void drop() {
    }

    @Override
    public void create() {
    }
}
