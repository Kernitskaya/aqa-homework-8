package ru.netology.selenium.utils;

import com.github.javafaker.Faker;
import ru.netology.selenium.domain.User;

public class Generator {

    private static Faker faker = new Faker();

    private Generator() {}

    public static User createUser() {
        String id = faker.internet().uuid();
        String login = faker.name().firstName().toLowerCase();
        String password = "$2a$10$EB8rib4WyLGPrzLmNeeZ5e6TvSmgfROT6P9oxbuebq.l3BIBVVF9O";
        String encryptedPassword = "qwerty123";
        String status = "active";
        return new User(id, login, password, encryptedPassword, status);
    }

    public static String createWrongPassword() {
        return String.valueOf(faker.number().numberBetween(0, 20));
    }
}
