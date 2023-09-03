package com.gudfeat.org.catalogweb.controller;

import com.gudfeat.org.catalogweb.model.Item;
import com.gudfeat.org.catalogweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemRestController {
//    @Autowired
//    private ItemService svc;
//
//    public ItemRestController(ItemService svc){
//        this.svc = svc;
//    }
//
//    @GetMapping
//    public List<Item> getAllRooms(){
//        return svc.getAllItems();
//    }
}
