package ru.netology.selenium.domain;

public class AuthCode {
    private String id;
    private String code;
    private String userId;
    private String created;

    public AuthCode(String id, String code, String userId, String created) {
        this.id = id;
        this.code = code;
        this.userId = userId;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getCreated() {
        return created;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "AuthCode{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", user_id='" + userId + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
