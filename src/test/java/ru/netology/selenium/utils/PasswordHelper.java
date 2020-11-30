package ru.netology.selenium.utils;

public class PasswordHelper {
    public static String getPasswordByUserLogin(String login) {
        String pasword;
        switch (login) {
            case "vasya": {
                pasword = "qwerty123";
                break;
            }
            default: {
                pasword = "";
            }
        }
        return pasword;
    }
}
