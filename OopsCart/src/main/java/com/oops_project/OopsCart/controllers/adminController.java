package com.oops_project.OopsCart.controllers;


import com.oops_project.OopsCart.models.*;
import com.oops_project.OopsCart.services.adminService;
import com.oops_project.OopsCart.services.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController

@RequestMapping("/api/")
public class adminController {

    @Autowired
    private adminService service;

    @Autowired
    private orderService ordservice;

    @PostMapping("/admin/login")
    public admin loginCustomer(@RequestBody login userinfo){

        return service.login(userinfo.username, userinfo.pwd);
    }

    @PostMapping("/updateAdmin")
    public admin update_admin(@RequestBody updateAdmin admininfo){
        return service.updateAdmin(admininfo.Admin,admininfo.password,admininfo.name,admininfo.email);

    }
    //remove later
    @GetMapping("/admins")
    public List<admin> showadmins(){
        return service.findAlladmin();
    }

    @GetMapping("/makeadmin")
    public admin makeadmin(){
        admin Admin = new admin("admin123","123","admin","admin.com","6969","007");
        return service.register(Admin);
    }

    @PostMapping("/registeradmin")
    public admin registerAdmin(@RequestBody admin Admin){

        return service.register(Admin);
    }

    @PostMapping("/admin/vieworders")
    public List<Order> vieworders(admin Admin){
        return ordservice.findAllOrder(Admin);
    }
}
