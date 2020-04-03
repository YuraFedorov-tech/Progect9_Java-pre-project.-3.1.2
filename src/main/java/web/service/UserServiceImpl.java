package web.service;
/*
 *
 *@Data 25.02.2020
 *@autor Fedorov Yuri
 *@project spring_hibernate
 *
 */


import org.springframework.stereotype.Service;
import web.config.model.Role;
import web.config.model.User;
import web.dao.RoleDao;
import web.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final private
    UserDao userDao;

    final private
    RoleDao roleDao;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }


    @Override
    public void add(User model, Long id) {
        userDao.add(model);
        model.addRoles(roleDao.findById(id));
        userDao.update(model);
    }

    @Override
    public void update(User model, Long []ids) {
        insideRoles(model,ids);
        userDao.update(model);
    }

    private void insideRoles(User model, Long[] ids) {
        List<Role> newRoles = new ArrayList<>();
        for (Long id:ids) {
            Role role = roleDao.findById(id);
            newRoles.add(role);
        }
        model.setRoles(newRoles);
    }

    @Override
    public User findModelByName(String name) {
        return userDao.findModelByName(name);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


    @Override
    public User findById(Long id) {

        return userDao.findById(id);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }


    @Override
    public void drop() {
        userDao.drop();
    }


    @Override
    public void create() {
        userDao.create();
    }
}
