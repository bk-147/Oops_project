package com.oops_project.OopsCart.models;

public class admin extends User{
    private String adminkey;

    public admin(String userId, String password, String name, String email, String phone, String adminkey) {
        super(userId, password, name, email, phone);
        this.adminkey = adminkey;
    }

    public admin() {
        super();
    }

    public String getAdminkey() {
        return adminkey;
    }

    public void setAdminkey(String adminkey) {
        this.adminkey = adminkey;
    }

    public void updateProfile(String password, String name, String email) {
        this.setPassword(password);
        this.setName(name);
        this.setEmail(email);


    }
}
