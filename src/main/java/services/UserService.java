package services;

import dao.UserDAO;
import dao.UserHibernateDAO;
import factory.UserDaoFactory;
import model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService userService;
    private UserDAO dao;

    private UserService(UserDaoFactory daoFactory) throws IOException {
        this.dao = daoFactory.getDao();
    }

    public static UserService getInstance() throws IOException{
        if (userService == null) {
            userService = new UserService(new UserDaoFactory());
        }
        return userService;
    }
    public List<User> getAllUsers() throws SQLException, IOException{
        return  dao.getAllUsers();
    }

    public User getUserById(long id) throws IOException{
        return (User) dao.getUserByID(id);

    }
    public void addUser (User user) throws IOException {
        if (!dao.isExistUser(user.getName())) {
            dao.addUser(user);
        }

    }
    public void update(User user, String name, String password, String email) throws IOException {
        dao.updateUser(user,name,password,email);
    }
    public void deleteUser(User user) throws IOException {
        dao.deleteUser(user);
    }
    public boolean isExistUser(String name) throws IOException {
        return dao.isExistUser(name);
    }


}
