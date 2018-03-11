package it.sevenbits.hellospring.web.controllers;

import it.sevenbits.hellospring.core.model.Item;
import it.sevenbits.hellospring.core.repository.ItemsRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@Controller
@RequestMapping("/items")
public class ItemsController {
    private final ItemsRepository itemsRepository;

    public ItemsController(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection collection() {
        return itemsRepository.getAllItems();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Item> create(
            @RequestBody Item newItem) {
        Item createdItem = itemsRepository.create(newItem);
        if (createdItem == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI location = UriComponentsBuilder.fromPath("/items/")
                    .path(String.valueOf(createdItem.getId()))
                    .build().toUri();
            return ResponseEntity.created(location)
                    .body(createdItem);
        }
    }

}
