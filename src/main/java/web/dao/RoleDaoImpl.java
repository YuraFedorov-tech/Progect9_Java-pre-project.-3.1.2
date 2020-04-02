package web.dao;
/*
 *
 *@Data 24.02.2020
 *@autor Fedorov Yuri
 *@project spring_hibernate
 *
 */


import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Role model) {

        entityManager.persist(model);
    }

    @Override
    public Role update(Role model) {
        return entityManager.merge(model);
    }

    @Override
    public void delete(Role role) {
        entityManager.remove(role);
    }

    @Override
    public List<Role> findAll() {
        return entityManager.createQuery("SELECT u FROM Role u").getResultList();


    }

    @Override
    public Role findModelByName(String name) {
        Query query = entityManager.createQuery("SELECT u FROM Role u where u.role = :role");
        query.setParameter("role", name);
        Role role = (Role) query.getSingleResult();
        return role == null ? null : role;
    }

    @Override
    public Role findById(Long id) {
        return entityManager.find(Role.class, id);
    }


    @Override
    public void drop() {
    }

    @Override
    public void create() {
    }
}
