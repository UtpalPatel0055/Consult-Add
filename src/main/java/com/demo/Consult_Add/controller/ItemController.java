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

@RestController
public class ItemController {

    Logger Logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ItemService itemService;

    @GetMapping("/get-item/{id}")
    public ResponseEntity<?> getItem(@PathVariable int id) {
        try {
            Item item = itemService.getItemById(id);
            if(item == null) {
                Logger.info("Item not found");
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
}
