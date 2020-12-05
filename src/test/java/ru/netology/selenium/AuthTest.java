package ru.netology.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.selenium.db.DbInteractionDbUtils;
import ru.netology.selenium.domain.AuthCode;
import ru.netology.selenium.domain.User;
import ru.netology.selenium.pages.AuthPage;
import ru.netology.selenium.utils.Generator;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest {
    private String startUrl = "http://localhost:9999";
    private User user;
    private AuthCode authCode;

    @AfterAll
    public static void tearDownClass() {
        DbInteractionDbUtils.clearAllTables();
    }

    @BeforeEach()
    public void setUpTest() {
        DbInteractionDbUtils.clearAllTables();
        user = Generator.createUser();
        authCode = Generator.createAuthCode(user);
        DbInteractionDbUtils.prepareUser(user, authCode);
    }

    @Test
    void testShouldAuth() {
        open(startUrl);
        AuthPage.newInstance().auth(user.getLogin(), user.getEncryptPassword())
                .enterCode(authCode.getCode()).checkTitle();
    }

    @Test
    void testShouldWrongPassword() {
        open(startUrl);
        AuthPage.newInstance().authWithWrongPassword(user.getLogin(), Generator.createWrongPassword())
                .clickContinue()
                .clickContinue().checkWrongAuthNotification();
    }
}
