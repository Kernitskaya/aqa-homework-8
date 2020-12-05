package ru.netology.selenium.domain;

public class User {
    String id;
    String login;
    String password;
    String encryptPassword;
    String status;

    public User(String id, String login, String password, String encryptPassword, String status) {
        this.id = id;
        this.login = login;
        this.encryptPassword = encryptPassword;
        this.password = password;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", encryptPassword='" + encryptPassword + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
