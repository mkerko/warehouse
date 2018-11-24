package com.wf.warehouse.service;

import com.wf.warehouse.domain.Item;
import com.wf.warehouse.exceptions.EntityWasNotFoundException;
import com.wf.warehouse.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item checkProductAvailability(long productId) throws EntityWasNotFoundException {
        Optional<Item> p = itemRepository.findById(productId);
        if (p.isPresent()){
            return p.get();
        } else {
            throw new EntityWasNotFoundException("Could not find product with id = " + productId);
        }
    }
}
