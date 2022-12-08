package com.oops_project.OopsCart.controllers;

import com.oops_project.OopsCart.models.*;
import com.oops_project.OopsCart.services.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

@RequestMapping("/api/")
public class customerController {

    @Autowired
    private customerService service;

    @PostMapping("/addCustomer")
    public Customer createCustomer(@RequestBody Customer customer){
        return service.register(customer);

    }
    //remove this later
    @GetMapping("/addCus")
    public login addcs() {
        login Login = new login();
        Login.username = "haha";
        Login.pwd= "1234";
        return Login;
    }
    @PostMapping("/Customers")
    public List<Customer> getCustom(@RequestBody admin Admin){
        return service.getCustomers(Admin);
    }




    @PostMapping("/Customers/login")
    public Customer loginCustomer(@RequestBody login userinfo){

        return service.login(userinfo.username, userinfo.pwd);
    }

    @PostMapping("/updateCustomer")
    public Customer update_customer(@RequestBody Customer customerinfo){
        return service.updateCustomer(customerinfo);

    }

    @PostMapping("/admin/deleteCustomer")
    public void admindeletecustomer(@RequestBody AdminDeleteUser adu){
        service.adminDeleteCustomer(adu);
    }

    @PostMapping("/customer/deleteCustomer")
    public  void deleteCustomer(@RequestBody login customer){

        service.deleteCustomer(customer);
    }


}
