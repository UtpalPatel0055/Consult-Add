package com.demo.Consult_Add.service;

import com.demo.Consult_Add.model.Item;
import com.demo.Consult_Add.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;


    public Item getItemById(int id) {
        Optional<Item> item = itemRepository.findById(id);

        if (item.isPresent()) {
            return item.get();
        }

        return null;
    }

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
}
