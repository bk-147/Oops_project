package com.oops_project.OopsCart.controllers;

import com.oops_project.OopsCart.models.Customer;
import com.oops_project.OopsCart.models.login;
import com.oops_project.OopsCart.models.updateCustomer;
import com.oops_project.OopsCart.services.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/Customers")
    public List<Customer> getCustom(){
        return service.getCustomers();
    }




    @PostMapping("/Customers/login")
    public Customer loginCustomer(@RequestBody login userinfo){

        return service.login(userinfo.username, userinfo.pwd);
    }

    @PostMapping("/updateCustomer")
    public Customer update_customer(@RequestBody updateCustomer customerinfo){
        return service.updateCustomer(customerinfo.customer,customerinfo.password, customerinfo.address,customerinfo.name,customerinfo.email);

    }

}
