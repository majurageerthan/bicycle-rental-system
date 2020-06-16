package dao.mapper;


import model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setNic(rs.getString("nic"));
        user.setFname(rs.getString("fname"));
        user.setLname(rs.getString("lname"));
        user.setDob(rs.getString("dob"));
        user.setSex(rs.getString("sex"));
        user.setPhone(rs.getInt("phone"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}