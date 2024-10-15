package com.demo.Consult_Add.controller;

import com.demo.Consult_Add.model.Item;
import com.demo.Consult_Add.repository.ItemRepository;
import com.demo.Consult_Add.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    Logger Logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ItemService itemService;

    @GetMapping("/items/{id}")
    public ResponseEntity<?> getItem(@PathVariable int id) {
        try {
            Item item = itemService.getItemById(id);
            if(item == null) {
                Logger.info("Item not found");
                return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (Exception e) {
            Logger.error("Error while getting item", e);
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save-item")
    public ResponseEntity<?> saveItem(@RequestBody Item item) {
        try {
            Item savedItem = itemService.saveItem(item);
            Logger.info("Item saved");
            return new ResponseEntity<>(savedItem, HttpStatus.OK);
        } catch (Exception e) {
            Logger.error("Error while creating item", e);
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/items")
    public ResponseEntity<?> getAllItems() {
        try {
            Logger.info("Getting all items");
            List<Item> li = itemService.getAllItems();
            return new ResponseEntity<>(li, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
