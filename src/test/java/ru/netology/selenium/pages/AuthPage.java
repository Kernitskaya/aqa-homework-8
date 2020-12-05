package ru.netology.selenium.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {

    SelenideElement loginField = $("[name='login']");
    SelenideElement passwordField = $("[name='password']");
    SelenideElement continueButton = $("[type='button']");
    SelenideElement wrongAuthNotification = $("[data-test-id='error-notification']");

    private AuthPage() {}

    public VerificationPage auth(String login, String password) {
        loginField.setValue(login);
        passwordField.setValue(password);
        continueButton.click();
        return VerificationPage.newInstance();
    }

    public AuthPage authWithWrongPassword(String login, String password) {
        loginField.setValue(login);
        passwordField.setValue(password);
        continueButton.click();
        return new AuthPage();
    }

    public AuthPage clickContinue() {
        continueButton.click();
        return new AuthPage();
    }

    public void checkWrongAuthNotification() {
        wrongAuthNotification.shouldHave(text("Неверно указан логин или пароль"));
    }

    public static AuthPage newInstance() {
        return new AuthPage();
    }
}
