package ru.netology.selenium.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage {

    SelenideElement loginField = $("[name='login']");
    SelenideElement passwordField = $("[name='password']");
    SelenideElement continueButton = $("[type='button']");

    private AuthPage() {}

    public VerificationPage auth(String login, String password) {
        loginField.setValue(login);
        passwordField.setValue(password);
        continueButton.click();
        // waiting insert into database
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return VerificationPage.newInstance();
    }

    public static AuthPage newInstance() {
        return new AuthPage();
    }
}
