package com.gudfeat.org.catalogweb.controller;

import com.gudfeat.org.catalogweb.model.Item;
import com.gudfeat.org.catalogweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/items")
public class ItemController {
    @Autowired
    ItemService svc;
    @GetMapping ("/items")
    public String getAllItems(Model model){
        model.addAttribute("items",svc.getAllItems());
        return "items";
    }

    @GetMapping("/addItem")
    public String showSignUpForm(Item item) {
        return "addItem";
    }

    @PostMapping("/add")
    public String createItem(Model model, @ModelAttribute Item item) {
        svc.createItem(item);
        model.addAttribute("item",getAllItems(model));
        //svc.createItem(item);
        return "items";
    }
    @GetMapping("/updateItem")
    public String updateItemForm(Item item) {
        return "updateItem";
    }

    @PostMapping("/update")
    public String updateItem(Model model, @ModelAttribute Item item) {
        svc.updateItem(item);
        model.addAttribute("item",getAllItems(model));
        //svc.createItem(item);
        return "items";
    }
    @GetMapping("/deleteItem")
    public String deleteItemForm(Item item) {
        return "deleteItem";
    }

    @PostMapping("/delete")
    public String deleteUser(Model model, @ModelAttribute Item item) {
        Item item2  = svc.findBy_Id(item.getId());
        if(item2!=null)
            svc.delete(item2);
        return "items";
    }
}
