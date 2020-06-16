package support;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

import static support.Constant.DATABASE_NAME;

public class DataSourceHelper {

    public static DataSource getDataSource(String userName, String password) {
        MysqlDataSource ds = new MysqlDataSource();
//        ds.setServerName(DATABASE_NAME);
        ds.setUser(userName);
        ds.setPassword(password);
//
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/" + DATABASE_NAME);
//        dataSource.setUsername(userName);
//        dataSource.setPassword(password);
        return ds;
    }

    public static DataSource getDataSourceWithDatabaseName(String userName, String password) {
        MysqlDataSource ds = new MysqlDataSource();
//        ds.setServerName(DATABASE_NAME);
        ds.setUser(userName);
        ds.setPassword(password);
        ds.setDatabaseName(DATABASE_NAME);
        return ds;
    }
}
