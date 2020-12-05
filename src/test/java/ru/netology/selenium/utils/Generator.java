package ru.netology.selenium.utils;

import com.github.javafaker.Faker;
import ru.netology.selenium.domain.AuthCode;
import ru.netology.selenium.domain.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Generator {

    private static Faker faker = new Faker();
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Generator() {}

    public static User createUser() {
        String id = faker.internet().uuid();
        String login = faker.name().firstName().toLowerCase();
        String password = "$2a$10$EB8rib4WyLGPrzLmNeeZ5e6TvSmgfROT6P9oxbuebq.l3BIBVVF9O";
        String encryptedPassword = "qwerty123";
        String status = "active";
        return new User(id, login, password, encryptedPassword, status);
    }

    public static AuthCode createAuthCode(User user) {
        int id = faker.number().numberBetween(0, 20);
        String code = faker.number().digits(6);
        String userCode = user.getId();
        String created = getDate();
        return new AuthCode(String.valueOf(id), code, userCode, created);
    }

    public static String createWrongPassword() {
        return String.valueOf(faker.number().numberBetween(0, 20));
    }

    private static String getDate() {
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now);
    }

}
