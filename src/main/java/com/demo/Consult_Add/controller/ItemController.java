package com.demo.Consult_Add.controller;

import com.demo.Consult_Add.model.Item;
import com.demo.Consult_Add.repository.ItemRepository;
import com.demo.Consult_Add.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    Logger Logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ItemService itemService;

    
}
