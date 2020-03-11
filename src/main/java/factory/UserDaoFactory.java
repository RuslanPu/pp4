package factory;

import dao.UserDAO;
import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import util.DBHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactory {
    public static UserDAO getDao() throws IOException {

        Properties properties = new Properties();
        ClassLoader loader = UserDaoFactory.class.getClassLoader();
        InputStream io = loader.getResourceAsStream("cfg.properties");
        properties.load(io);
        if (properties.getProperty("type").equalsIgnoreCase("Hibernate")) {
            return new UserHibernateDAO(DBHelper.getInstance().getConfiguration().openSession());
        } else if (properties.getProperty("type").equalsIgnoreCase("jdbc")) {
            return new UserJdbcDAO(DBHelper.getInstance().getConnection());
        } else {
            return null;
        }
    }
}
