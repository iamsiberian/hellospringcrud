package it.sevenbits.hellospring.core.repository;

import it.sevenbits.hellospring.core.model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SampleItemsRepository implements ItemsRepository {

    List<Item> items = new ArrayList<>();
    public SampleItemsRepository() {
        //...
        items.add(new Item(1, "one"));
        items.add(new Item(2, "two"));
        items.add(new Item(3, "three"));
    }

    @Override
    public List<Item> getAllItems() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public Item create(Item newItem) {
        items.add(newItem);
        return newItem;
    }

    @Override
    public Item getItemById(long id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Item update(long id, Item newItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.set(i, newItem);
                return items.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }


}
