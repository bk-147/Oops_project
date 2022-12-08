package com.oops_project.OopsCart.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("Customers")
public class Customer extends User {
    @Field
    private String address;
    @Field
    private String ShippingInfo;
    @Field
    private Float WalletBalance;

    @Field
    private List cart;

    @Field
    private int cartTotal;

    public Customer(String userId, String password, String name, String email, String phone, String address) {
        super(userId, password, name, email, phone);
        this.address = address;

        this.WalletBalance = Float.valueOf(1000);
    }

    Customer() {
        super();
    }

    public void updateProfile(String password, String address, String name, String email,Float walletBalance,List cart,int cartTotal) {
        this.setPassword(password);
        this.setName(name);
        this.setEmail(email);
        this.setAddress(address);
        this.setWalletBalance(walletBalance);
        this.setCart(cart);
        this.setCartTotal(cartTotal);


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

    public List getCart() {
        return cart;
    }

    public void setCart(List cart) {
        this.cart = cart;
    }

    public int getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(int cartTotal) {
        this.cartTotal = cartTotal;
    }
}