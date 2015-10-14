package org.demo.thm.rest;

import org.demo.thm.entity.Item;
import org.demo.thm.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemResource {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public Item getOne(@PathVariable int itemId) {
        return itemRepository.findOne(itemId);
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public Iterable<Item> getAll() {
        return itemRepository.findAll();
    }

    @RequestMapping(value = "/item", method = RequestMethod.PUT)
    public ResponseEntity create(@RequestBody Item item) {
        itemRepository.save(item);
        return new ResponseEntity(HttpStatus.CREATED);
    }



}
