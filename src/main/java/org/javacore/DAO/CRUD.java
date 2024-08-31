package org.javacore.DAO;

import java.util.List;

public interface CRUD<T> {
    Boolean insert(T t);
    Boolean update(T t);
    Boolean deleteById(Integer id);
    List<T> read();
}
