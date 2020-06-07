package service;

import java.sql.*;

import static support.Constant.DATABASE_NAME;
import static support.Constant.JDBC_URL;

public class JDBCConnection {


    public void login(String userName, String password) {
        String SQL_SELECT = "show databases";
        String url = JDBC_URL + DATABASE_NAME;
        try (Connection conn = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();
/*
            while (resultSet.next()) {

                long id = resultSet.getLong("ID");
                String name = resultSet.getString("NAME");
                BigDecimal salary = resultSet.getBigDecimal("SALARY");
                Timestamp createdDate = resultSet.getTimestamp("CREATED_DATE");

                Employee obj = new Employee();
                obj.setId(id);
                obj.setName(name);
                obj.setSalary(salary);
                // Timestamp -> LocalDateTime
                obj.setCreatedDate(createdDate.toLocalDateTime());

                result.add(obj);

            }
            result.forEach(x -> System.out.println(x));*/

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//            throw new SQLException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
