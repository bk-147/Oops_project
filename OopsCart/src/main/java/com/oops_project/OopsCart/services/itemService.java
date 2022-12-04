package com.oops_project.OopsCart.services;

import com.oops_project.OopsCart.models.Item;
import com.oops_project.OopsCart.repositories.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class itemService {

    @Autowired
    private itemRepository itemrepo;




    //CRUD operation go here

    //Saving in DB
    public Item addItem(Item item){
        item.setId(UUID.randomUUID().toString());

        return itemrepo.save(item);
    }

    //Reading from DB
    public List<Item> findAllItem(){
        return itemrepo.findAll();
    }

    public Item findItemById(String s){
        return itemrepo.findById(s).get();
    }


}
