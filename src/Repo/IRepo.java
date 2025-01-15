package Repo;

import java.util.List;

public interface IRepo<T> {

    void add(T obj);
    void update(T obj);
    void delete(int id);
    T get(int id);
    List<T> getAll();

}
