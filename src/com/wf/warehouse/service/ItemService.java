package com.wf.warehouse.service;

import com.wf.warehouse.domain.Item;
import com.wf.warehouse.exception.EntityWasNotFoundException;
import com.wf.warehouse.repository.ItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item retrieveItem(long itemId) throws EntityWasNotFoundException {
        log.debug("Retrieving item from warehouse");
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        itemOptional.orElseThrow(() -> new EntityWasNotFoundException("Could not find product with id = " + itemId));
        return itemOptional.get();
    }
}
