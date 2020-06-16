package service;

import model.LogInUser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import support.SQLScriptHelper;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static support.Constant.SQL_FILE_CREATE_DATABASE_AND_TABLES;
import static support.Constant.SQL_FILE_CREATE_USERS_AND_PRIVILEGES;

public class SQLScriptRunner {

    public static void initializeDatabaseAndTablesWithPermissions(DataSource dataSource) {
        LogInUser logInUser = new LogInUser();
        logInUser.setDataSource(dataSource);
        executeSQLScript(logInUser, SQL_FILE_CREATE_DATABASE_AND_TABLES);
        executeSQLScript(logInUser, SQL_FILE_CREATE_USERS_AND_PRIVILEGES);
        loadInitialValues(logInUser);

    }

    private static void loadInitialValues(LogInUser logInUser) {
        List<String> loadDatabase = SQLScriptHelper.getInitializeDumbValueScripts();

        for (String sqlFile : loadDatabase) {
            executeSQLScript(logInUser, sqlFile);
        }
    }


    public static void executeSQLScript(LogInUser logInUser, String fileCode) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(logInUser.getDataSource());
        String sql = getSQLAsString(fileCode);
        String[] sqls = sql.split(";");
        System.out.println(Arrays.toString(sqls));
        for (String sqlQuery : sqls) {
            if (sqlQuery.length() > 3)
                jdbcTemplate.update(sqlQuery);
        }
    }

    private static String getSQLAsString(String fileCode) {
        Resource resource = new ClassPathResource(fileCode);
//        File sqlFile = resource.getFile();
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(resource.getFile().toPath(), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
}
