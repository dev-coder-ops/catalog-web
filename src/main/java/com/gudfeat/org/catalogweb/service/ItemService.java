package com.gudfeat.org.catalogweb.service;

import com.gudfeat.org.catalogweb.model.Item;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {


//    private static final List<Item> items = new ArrayList();
//    static {
//        for (int i = 0; i < 10; i++) {
//            items.add(new Item(i, "Item" + i, "Item desc+i"));
//        }
//    }
//    public List<Item> getAllItems_old(){
//        return items;
//    }

    public List<Item> getAllItems(){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "http://localhost:8000/items";
        // Fetch JSON response as String wrapped in ResponseEntity
        ResponseEntity<List> response
                = restTemplate.getForEntity(resourceUrl, List.class);
        List<Item> items = response.getBody();
        return items;
    }

    public void createItem(Item item) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "http://localhost:8000/items";
        // Create the request body by wrapping
        // the object in HttpEntity
        HttpEntity<Item> request =
                new HttpEntity<Item>(item);
        ResponseEntity<String> productCreateResponse =
                restTemplate
                        .exchange(resourceUrl,
                                HttpMethod.POST,
                                request,
                                String.class);
        System.out.println(productCreateResponse);
    }

    public void updateItem(Item item) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "http://localhost:8000/items";
        // Create the request body by wrapping
        // the object in HttpEntity
        HttpEntity<Item> request =
                new HttpEntity<Item>(item);
        ResponseEntity<String> productCreateResponse =
                restTemplate
                        .exchange(resourceUrl,
                                HttpMethod.PUT,
                                request,
                                String.class);
        System.out.println(productCreateResponse);
    }

    public Optional<Item> findById(long id){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "http://localhost:8000/items";
        // Fetch JSON response as String wrapped in ResponseEntity
        ResponseEntity<Optional> response
                = restTemplate.getForEntity(resourceUrl, Optional.class);
        Optional<Item> item = response.getBody();
        System.out.println(item);
        return item;
    }

    public Item findBy_Id(long id){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "http://localhost:8000/items/getItemBy_Id/{id}";
        // Fetch JSON response as String wrapped in ResponseEntity
        ResponseEntity<Item> response
                = restTemplate.getForEntity(resourceUrl, Item.class,id);
        Item item = response.getBody();
        System.out.println(item);
        return item;
    }

    public void delete(Item item) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "http://localhost:8000/items";
        // Create the request body by wrapping
        // the object in HttpEntity
        HttpEntity<Item> request =
                new HttpEntity<Item>(item);
        ResponseEntity<String> productCreateResponse =
                restTemplate
                        .exchange(resourceUrl,
                                HttpMethod.DELETE,
                                request,
                                String.class);
        System.out.println(productCreateResponse);
    }


}
