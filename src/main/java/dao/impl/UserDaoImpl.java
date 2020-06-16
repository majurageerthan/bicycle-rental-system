package dao.impl;

import dao.UserDao;
import dao.mapper.UserMapper;
import model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplateObject;

    public UserDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public void setDataSource(DataSource ds) {
        this.jdbcTemplateObject = new JdbcTemplate(ds);
    }

    @Override
    public void create(User user) {
        String SQL = "insert into user (nic, fname,lname,dob,sex,phone,email) values (?,?,?,?,?,?,?)";
        jdbcTemplateObject.update(SQL, user.getNic(), user.getFname(), user.getLname(), user.getDob(), user.getSex(), user.getPhone(), user.getEmail());
//        System.out.println("Created Record Name = " + name + " Age = " + age);
//        return;
    }

    @Override
    public User getUser(String id) {
        String SQL = "select * from user where nic = ?";
        return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new UserMapper());
    }

    @Override
    public List<User> listUsers() {
        String SQL = "select * from user";
        return jdbcTemplateObject.query(SQL, new UserMapper());
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(User user) {

    }
}
