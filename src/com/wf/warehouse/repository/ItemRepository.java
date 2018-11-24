package com.wf.warehouse.repository;


import com.wf.warehouse.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
