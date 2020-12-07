package ru.netology.selenium.domain;

public class AuthCode {
    private String id;
    private String code;
    private String userId;
    private String created;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
