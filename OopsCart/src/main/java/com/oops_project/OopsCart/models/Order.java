package com.oops_project.OopsCart.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Orders")
public class Order {
    private String orderid;
    private Customer customer;
    private List<Item> orderItems;

    Order(){

    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Item> orderItems) {
        this.orderItems = orderItems;
    }
}
