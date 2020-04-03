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
import web.config.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {


    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void add(Role model) {

        entityManager.persist(model);
    }

    @Transactional
    @Override
    public void update(Role model) {
        entityManager.merge(model);
    }

    @Transactional
    @Override
    public void delete(Role role) {
        entityManager.remove(role);
    }


    @Transactional(readOnly = true)
    @Override
    public List<Role> findAll() {
        return entityManager.createQuery("SELECT u FROM Role u").getResultList();


    }

    @Transactional(readOnly = true)
    @Override
    public Role findModelByName(String name) {
        Query query = entityManager.createQuery("SELECT u FROM Role u where u.role = :role");
        query.setParameter("role", name);
        List<Role> roles = query.getResultList();
        if (roles.size() > 0) {
            return roles.get(0);
        }
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Role findById(Long id) {
        Query query = entityManager.createQuery("SELECT u FROM Role u where u.id = :id");
        query.setParameter("id", id);
        List<Role> roles = query.getResultList();
        if (roles.size() > 0) {
            return roles.get(0);
        }
        return null;
    }


    @Override
    public void drop() {
    }

    @Override
    public void create() {
    }
}
