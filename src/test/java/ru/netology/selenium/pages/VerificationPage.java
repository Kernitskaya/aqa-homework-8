package ru.netology.selenium.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    SelenideElement code = $("[name='code']");
    SelenideElement continueButton = $("[type='button']");

    private VerificationPage() {}

    public static VerificationPage newInstance() {
        return new VerificationPage();
    }

    public PrivateOfficePage enterCode(String code) {
        this.code.setValue(code);
        continueButton.click();
        return PrivateOfficePage.newInstance();
    }
}
