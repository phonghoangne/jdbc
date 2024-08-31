package org.javacore.DAO;

import java.util.List;

// tao interface de dung chung (Mentor, Student)
public interface Service<T> {
    Boolean insert(T t);
    Boolean update(T t);
    Boolean deleteById(Integer id);
    T findById(Integer id);
    List<T> findAll();
}
