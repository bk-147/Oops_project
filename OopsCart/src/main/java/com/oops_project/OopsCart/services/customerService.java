package com.oops_project.OopsCart.services;

import com.oops_project.OopsCart.models.AdminDeleteUser;
import com.oops_project.OopsCart.models.Customer;
import com.oops_project.OopsCart.models.admin;
import com.oops_project.OopsCart.models.login;
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
            customer.setLoginStatus(true);
            return customer;
        }
        else{return null;}
    }

    //update profile
    public Customer updateCustomer(Customer customer){

        Customer customer1 = customer_repo.findById(customer.getUserId()).get();
        if(customer1.getPassword().equals(customer.getPassword())){
            customer1.updateProfile(customer.getPassword(),customer.getAddress(),customer.getName(),customer.getEmail(),customer.getWalletBalance());
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
    public List<Customer> getCustomers(admin Admin){
        if(Admin.getAdminkey().equals("007")){
            return customer_repo.findAll();
        }
        else{
            return null;
        }
    }

    //get customer by id
    public Customer findCustomerById(String s){
        return customer_repo.findById(s).get();
    }

    //delete account
    public void deleteCustomer(login customer){
        Customer customer1 = customer_repo.findById(customer.username).get();
        if(customer1.getPassword().equals(customer.pwd)){
            customer_repo.delete(customer1);
        }


    }

    // admin delete customer
    public void adminDeleteCustomer(AdminDeleteUser adu){
        if(adu.Admin.getAdminkey().equals("007")){
            customer_repo.delete(adu.customer);
        }


    }

}
