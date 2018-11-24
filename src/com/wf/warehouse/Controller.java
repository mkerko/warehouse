package com.wf.warehouse;

import com.wf.warehouse.domain.Item;
import com.wf.warehouse.exceptions.EntityWasNotFoundException;
import com.wf.warehouse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final ItemService itemService;

    @Autowired
    public Controller(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/checkProductAvailability")
    public Item checkProductAvailability(@RequestParam(name = "productId") Long productId){
        try {
            Item item = itemService.checkProductAvailability(productId);
            return item;
        } catch (EntityWasNotFoundException e) {
            return null;
        }
    }
}
