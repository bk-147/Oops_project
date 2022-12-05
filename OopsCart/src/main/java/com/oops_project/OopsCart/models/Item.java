package com.oops_project.OopsCart.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Items")
public class Item {
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private int price;

    @Field
    private int quantity;


    public Item(String id,String name,int price,int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public Item(String name,int price){
        this.name = name;
        this.price = price;
    }

    public Item(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}