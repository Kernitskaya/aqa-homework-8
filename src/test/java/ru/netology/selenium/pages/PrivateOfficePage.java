package ru.netology.selenium.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PrivateOfficePage {

    private static String TITLE_TEXT = "Личный кабинет";

    SelenideElement title = $("[data-test-id='dashboard']");

    private PrivateOfficePage() {}

    public static PrivateOfficePage newInstance() {
        return new PrivateOfficePage();
    }

    public void checkTitle() {
        title.shouldHave(text(TITLE_TEXT));
    }
}
