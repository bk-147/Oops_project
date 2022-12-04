package com.oops_project.OopsCart.controllers;

import com.oops_project.OopsCart.models.Item;
import com.oops_project.OopsCart.services.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class itemController {

    @Autowired
    private itemService service;

    @GetMapping("/Items")
    public List<Item> getItem(){
        return service.findAllItem();
    }


    @PostMapping("/Items")
    public Item createItem(@RequestBody Item item){

        return service.addItem(item);
    }

    @GetMapping("/Items/{id}")
    public Item getItemById(@PathVariable String id){

        return service.findItemById(id);
    }
}
