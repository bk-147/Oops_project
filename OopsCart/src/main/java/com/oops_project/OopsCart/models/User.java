package com.oops_project.OopsCart.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Users")
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


}
