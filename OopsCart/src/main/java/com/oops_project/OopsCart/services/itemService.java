package com.oops_project.OopsCart.services;

import com.oops_project.OopsCart.models.Item;
import com.oops_project.OopsCart.models.addItem;
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
    public Item addItem(addItem addItemobj){

        if(addItemobj.Admin.getAdminkey().equals("007")){

            addItemobj.item.setId(UUID.randomUUID().toString());


            return itemrepo.save(addItemobj.item);
        }
        else{return null;}

    }

    //Reading from DB
    public List<Item> findAllItem(){
        return itemrepo.findAll();
    }

    public Item findItemById(String s){
        return itemrepo.findById(s).get();
    }

    public void remove(addItem addItemobj){

        if(addItemobj.Admin.getAdminkey().equals("007")){



             itemrepo.delete(addItemobj.item);
        }


    }
    public Item modifyItem(addItem addItemobj){

        if(addItemobj.Admin.getAdminkey().equals("007")){

            Item item = itemrepo.findById(addItemobj.item.getId()).get();
            item.setPrice(addItemobj.item.getPrice());
            item.setName(addItemobj.item.getName());
            item.setQuantity(addItemobj.item.getQuantity());
            item.setDescription(addItemobj.item.getDescription());
            item.setImage(addItemobj.item.getImage());

            return itemrepo.save(item);
        }
        else{return null;}

    }






}
