package com.oops_project.OopsCart.services;

import com.oops_project.OopsCart.models.Customer;
import com.oops_project.OopsCart.repositories.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class customerService {

    @Autowired
    private customerRepository customer_repo;

    //registering a new customer
    public Customer register(Customer customer){

        return customer_repo.save(customer);

    }
    //login status
    public Customer login(String userid,String pass){
        Customer customer = customer_repo.findById(userid).get();
        if( pass.equals(customer.getPassword())){

            return customer;
        }
        else{return null;}
    }

    //update profile
    public Customer updateCustomer(Customer customer,String password,String address,String name,String email){

        Customer customer1 = customer_repo.findById(customer.getUserId()).get();
        if(customer1.getPassword().equals(customer.getPassword())){
            customer.updateProfile(password,address,name,email);
            return customer_repo.save(customer);
        }
        else{
            return null;
        }

    }
    //view wallet
    public Float view_wallet(String s){

        return customer_repo.findById(s).get().getWalletBalance();
    }

    //get all customers
    public List<Customer> getCustomers(){
        return customer_repo.findAll();
    }

    //get customer by id
    public Customer findCustomerById(String s){
        return customer_repo.findById(s).get();
    }

    //delete account
    public void deleteCustomer(Customer customer){
        customer_repo.delete(customer);
    }


}