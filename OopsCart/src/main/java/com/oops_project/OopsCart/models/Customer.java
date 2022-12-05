package com.oops_project.OopsCart.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Customers")
public class Customer extends User {
    @Field
    private String address;
    @Field
    private String ShippingInfo;
    @Field
    private Float WalletBalance;


    public Customer(String userId, String password, String name, String email, String phone, String address) {
        super(userId, password, name, email, phone);
        this.address = address;

        this.WalletBalance = Float.valueOf(1000);
    }

    Customer() {
        super();
    }

    public void updateProfile(String password, String address, String name, String email) {
        this.setPassword(password);
        this.setName(name);
        this.setEmail(email);
        this.setAddress(address);


    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShippingInfo() {
        return ShippingInfo;
    }

    public void setShippingInfo(String shippingInfo) {
        ShippingInfo = shippingInfo;
    }

    public Float getWalletBalance() {
        return WalletBalance;
    }

    public void setWalletBalance(Float walletBalance) {
        WalletBalance = walletBalance;
    }


}