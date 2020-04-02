package web.service;

import java.util.List;

public interface DaoService <T> {

    void add(T model,Long ids);
    List<T> findAll();
    T findById(Long id);
    void delete(T model);
    void drop();
    void create();
    void update(T model, Long[]ids);
    T findModelByName(String name);
}
