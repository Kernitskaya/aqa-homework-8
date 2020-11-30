package ru.netology.selenium;

import org.junit.jupiter.api.Test;
import ru.netology.selenium.db.DbInteractionDbUtils;
import ru.netology.selenium.domain.User;
import ru.netology.selenium.pages.AuthPage;
import ru.netology.selenium.utils.PasswordHelper;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest {
    private String startUrl = "http://localhost:9999";

    @Test
    void testShouldAuth() {
        open(startUrl);
        try {
            User user = DbInteractionDbUtils.getUserByLogin("vasya");
            AuthPage.newInstance().auth(user.getLogin(), PasswordHelper.getPasswordByUserLogin(user.getLogin()))
                    .enterCode(DbInteractionDbUtils.getUserAuthCodeById(user.getId())).checkTitle();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
