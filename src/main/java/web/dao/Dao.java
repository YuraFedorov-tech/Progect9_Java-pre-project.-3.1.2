package web.dao;

import java.util.List;

/*
 *
 *@Data 24.02.2020
 *@autor Fedorov Yuri
 *@project spring_hibernate
 *
 */
public interface Dao<T> {
    void add(T model);
    List<T> findAll();
    T findById(Long id);
    void delete(T model);
    void drop();
    void create();
    T update(T model);
    T findModelByName(String name);
}
