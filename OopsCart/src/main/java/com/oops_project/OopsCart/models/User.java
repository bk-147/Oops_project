package com.oops_project.OopsCart.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;


public class User {

    @Id
    private String userId;

    @Field
    private String password;

    @Field
    private String name;

    @Field
    private String email;

    @Field
    private String phone;

    @Field
    private boolean loginStatus;

    public User(String userId, String password, String name, String email, String phone) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;

    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
}
