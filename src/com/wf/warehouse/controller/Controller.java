package com.wf.warehouse.controller;

import com.wf.warehouse.domain.Item;
import com.wf.warehouse.exception.EntityWasNotFoundException;
import com.wf.warehouse.service.ItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class Controller {

    private final ItemService itemService;

    @Autowired
    public Controller(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/retrieveWarehouseItem")
    public Item checkProductAvailability(@RequestParam(name = "itemId") Long itemId) throws EntityWasNotFoundException {
        log.debug("retrieveWarehouseItem has been called");
        return itemService.retrieveItem(itemId);
    }
}
