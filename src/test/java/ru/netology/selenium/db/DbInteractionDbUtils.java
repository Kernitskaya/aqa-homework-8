package ru.netology.selenium.db;

import org.apache.commons.dbutils.QueryRunner;
import ru.netology.selenium.domain.AuthCode;
import ru.netology.selenium.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbInteractionDbUtils {

    private static String URL = "jdbc:mysql://localhost:3306/app";
    private static String USER = "app";
    private static String PASSWORD = "9mREsvXDs9Gk89Ef";

    public static void prepareUser(User user, AuthCode authCode) {
        try {
            String insertUser = "INSERT INTO users(id, login, password, status) VALUES (?, ?, ?, ?);";
            String insertAuthCode = "INSERT INTO auth_codes(id, user_id, code, created) VALUES (?, ?, ?, ?);";
            QueryRunner runner = new QueryRunner();

            try (
                    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD))
            {
                runner.update(conn, insertUser,
                        user.getId(),
                        user.getLogin(),
                        user.getPassword(),
                        user.getStatus());
                runner.update(conn, insertAuthCode,
                        authCode.getId(),
                        authCode.getUserId(),
                        authCode.getCode(),
                        authCode.getCreated());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
