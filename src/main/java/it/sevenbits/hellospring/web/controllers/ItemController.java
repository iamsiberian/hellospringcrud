package it.sevenbits.hellospring.web.controllers;

import it.sevenbits.hellospring.core.model.Item;
import it.sevenbits.hellospring.core.repository.ItemsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/items/{id}")
public class ItemController {

    private final ItemsRepository itemsRepository;

    public ItemController(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Item> get(@PathVariable long id) {
        /*
        try {
            Item result = itemsRepository.getItemById(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        */

        Item result = itemsRepository.getItemById(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }

    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Item> update(
            @PathVariable long id, @RequestBody Item newItem) {
        Item result = itemsRepository.update(id, newItem);
        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI location = UriComponentsBuilder.fromPath("/items/")
                    .path(String.valueOf(result.getId()))
                    .build().toUri();
            return ResponseEntity.created(location).body(result);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable long id) {
        boolean deleted = itemsRepository.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
