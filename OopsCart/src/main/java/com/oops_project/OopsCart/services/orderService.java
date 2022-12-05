package com.oops_project.OopsCart.services;

import com.oops_project.OopsCart.models.Customer;
import com.oops_project.OopsCart.models.Item;
import com.oops_project.OopsCart.models.Order;
import com.oops_project.OopsCart.models.admin;
import com.oops_project.OopsCart.repositories.customerRepository;
import com.oops_project.OopsCart.repositories.itemRepository;
import com.oops_project.OopsCart.repositories.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderService {

    @Autowired
    private orderRepository orderrepo;

    @Autowired
    private customerRepository customer_repo;

    @Autowired
    private itemRepository item_repo;


    public List<Order> findAllOrder(admin Admin){

        if(Admin.getAdminkey().equals("007")){



            return orderrepo.findAll();
        }
        else {
            return null;
        }
    }
    public Order makeOrder(Order order){
        Customer customer = customer_repo.findById(order.getCustomer().getUserId()).get();
        if(customer.getPassword().equals(order.getCustomer().getPassword())){

            int ordersize = order.getOrderItems().size();
            float total=0;
            List<Item> orderitems = order.getOrderItems();

            for(int i=0;i<ordersize;i++){
                total+= orderitems.get(i).getPrice();
            }

            if(customer.getWalletBalance()>= total){
                boolean success = true;
                customer.setWalletBalance(customer.getWalletBalance()-total );
                for(int i=0;i<ordersize;i++){
                    Item item = item_repo.findById(orderitems.get(i).getId()).get();
                    int orderquantity = orderitems.get(i).getQuantity();
                    int itemquantity = item.getQuantity();
                    int newitemquant = itemquantity - orderquantity;
                    if(newitemquant>=0){
                        item.setQuantity(newitemquant);
                        item_repo.save(item);
                    }
                    else{
                        success = false;

                    }
                }

                if(success){return orderrepo.save(order);}
                else{return null;}

            }
            else{return null;}




        }
        else{return null;}


    }


}
