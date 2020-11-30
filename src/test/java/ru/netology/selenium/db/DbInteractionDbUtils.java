package ru.netology.selenium.db;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import ru.netology.selenium.domain.AuthCode;
import ru.netology.selenium.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbInteractionDbUtils {

    private static String URL = "jdbc:mysql://localhost:3306/app";
    private static String USER = "app";
    private static String PASSWORD = "9mREsvXDs9Gk89Ef";

    public static User getUserByLogin(String login) throws SQLException {
        String usersSQL = String.format("SELECT * FROM users WHERE login='%s';", login);
        QueryRunner runner = new QueryRunner();

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        ) {
            return runner.query(conn, usersSQL, new BeanHandler<>(User.class));
        }
    }

    public static String getUserAuthCodeById(String id) throws SQLException {
        String usersSQL = String.format("SELECT * FROM auth_codes WHERE user_id='%s' ORDER BY created DESC;", id);
        QueryRunner runner = new QueryRunner();

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        ) {
            AuthCode authCode = runner.query(conn, usersSQL, new BeanHandler<>(AuthCode.class));
            return authCode.getId();
        }
    }
}
