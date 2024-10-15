package com.demo.Consult_Add.repository;

import com.demo.Consult_Add.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    
}
