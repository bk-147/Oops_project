package com.oops_project.OopsCart.controllers;


import com.oops_project.OopsCart.models.*;
import com.oops_project.OopsCart.services.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/")
public class adminController {

    @Autowired
    private adminService service;

    @PostMapping("/admin/login")
    public admin loginCustomer(@RequestBody login userinfo){

        return service.login(userinfo.username, userinfo.pwd);
    }

    @PostMapping("/updateAdmin")
    public admin update_admin(@RequestBody updateAdmin admininfo){
        return service.updateAdmin(admininfo.Admin,admininfo.password,admininfo.name,admininfo.email);

    }
}
