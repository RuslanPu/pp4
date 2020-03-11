package dao;

import java.util.List;

public interface UserDAO<T>{
    List<T> getAllUsers();

    void addUser(T t);

    void updateUser(T t, String name, String password, String email);

    void deleteUser(T t);

    T getUserByID(long id);

    boolean isExistUser(String name);

}
