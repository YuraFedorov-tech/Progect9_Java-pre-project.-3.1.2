package web.dao;
/*
 *
 *@Data 24.02.2020
 *@autor Fedorov Yuri
 *@project spring_hibernate
 *
 */


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User model) {
        entityManager.persist(model);
    }

    @Override
    public User update(User model) {
        return entityManager.merge(model);
    }

    @Override
    public User findModelByName(String email) {
        Query query = entityManager.createQuery("SELECT u FROM User u where u.email = :email");
        query.setParameter("email", email);
        User user = (User) query.getSingleResult();
        return user == null ? null : user;
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    public void drop() {
    }

    @Override
    public void create() {
    }
}
