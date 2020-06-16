package dao;

import model.User;

import javax.sql.DataSource;
import java.util.List;

public interface UserDao {

    public void setDataSource(DataSource ds);

    public void create(User user);

    public User getUser(String id);

    public List<User> listUsers();

    public void delete(Integer id);

    public void update(User user);
}
