package ru.netology.selenium.domain;

public class AuthCode {
    private String id;
    private String code;
    private String user_id;
    private String created;

    public String getId() {
        return id;
    }

    public void setCode(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "AuthCode{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", user_id='" + user_id + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
