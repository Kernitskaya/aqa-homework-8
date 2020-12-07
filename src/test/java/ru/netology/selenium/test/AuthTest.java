package ru.netology.selenium.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.selenium.db.DbInteractionDbUtils;
import ru.netology.selenium.domain.AuthCode;
import ru.netology.selenium.domain.User;
import ru.netology.selenium.pages.AuthPage;
import ru.netology.selenium.pages.VerificationPage;
import ru.netology.selenium.utils.Generator;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest {
    private String startUrl = "http://localhost:9999";
    private User user;

    @AfterAll
    public static void tearDownClass() {
        DbInteractionDbUtils.clearAllTables();
    }

    @BeforeEach()
    public void setUpTest() {
        user = Generator.createUser();
        DbInteractionDbUtils.prepareUser(user);
    }

    @Test
    void testShouldAuth() {
        open(startUrl);
        VerificationPage verificationPage = AuthPage.newInstance().auth(user.getLogin(), user.getEncryptPassword());
        AuthCode authCode = DbInteractionDbUtils.getLastAuthCodeById(user);
        verificationPage.enterCode(authCode.getCode()).checkTitle();
    }

    @Test
    void testShouldWrongPassword() {
        open(startUrl);
        AuthPage.newInstance().authWithWrongPassword(user.getLogin(), Generator.createWrongPassword())
                .clickContinue()
                .clickContinue().checkWrongAuthNotification();
    }
}
