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

    public static void prepareUser(User user) {
        try {
            String insertUser = "INSERT INTO users(id, login, password, status) VALUES (?, ?, ?, ?);";
             QueryRunner runner = new QueryRunner();

            try (
                    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD))
            {
                runner.update(conn, insertUser,
                        user.getId(),
                        user.getLogin(),
                        user.getPassword(),
                        user.getStatus());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static AuthCode getLastAuthCodeById(User user) {
        AuthCode authCode = new AuthCode();
        // waiting DB
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            String getAuthCodeQuery = String.format("SELECT * FROM auth_codes WHERE user_id='%s'", user.getId());
            QueryRunner runner = new QueryRunner();

            try (
                    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD))
            {
                authCode = runner.query(conn, getAuthCodeQuery, new BeanHandler<>(AuthCode.class));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return authCode;
    }

    public static void clearAllTables() {
        clearCardTransactions();
        clearCards();
        clearAuthCodes();
        clearUsers();
    }

    private static void clearUsers() {
        try {
            String clearUserTable = "DELETE FROM users";
            QueryRunner runner = new QueryRunner();

            try (
                    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            ) {
                runner.update(conn, clearUserTable);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void clearAuthCodes() {
        try {
            String clearAuthCodes = "DELETE FROM auth_codes";
            QueryRunner runner = new QueryRunner();

            try (
                    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            ) {
                runner.update(conn, clearAuthCodes);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void clearCards() {
        try {
            String clearCards = "DELETE FROM cards";
            QueryRunner runner = new QueryRunner();

            try (
                    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            ) {
                runner.update(conn, clearCards);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void clearCardTransactions() {
        try {
            String clearCards = "DELETE FROM card_transactions";
            QueryRunner runner = new QueryRunner();

            try (
                    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            ) {
                runner.update(conn, clearCards);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
