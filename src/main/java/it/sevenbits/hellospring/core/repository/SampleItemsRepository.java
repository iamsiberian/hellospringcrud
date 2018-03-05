package it.sevenbits.hellospring.core.repository;

import it.sevenbits.hellospring.core.model.Item;

import java.util.*;

public class SampleItemsRepository implements ItemsRepository {

    TreeMap<Long, Item> items = new TreeMap<>();

    public SampleItemsRepository() {
        //...
        items.put((long) 1, new Item(1, "Ivan", "Ivanov"));
        items.put((long) 2, new Item(2, "Petr", "Petrov"));
        items.put((long) 3, new Item(3, "Sidr", "Sidorov"));
    }

    @Override
    public Collection<Item> getAllItems() {
        return Collections.unmodifiableCollection(items.values());
    }

    @Override
    public Item create(Item newItem) {
        items.put(getNewID() ,newItem);
        return newItem;
    }

    @Override
    public Item getItemById(long id) {
        if (items.containsKey(id)) {
            return items.get(id);
        }
        return null;
    }

    @Override
    public Item update(long id, Item newItem) {
        if (items.containsKey(id)) {
            items.put(id, newItem);
            return newItem;
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        if (items.containsKey(id)) {
            items.remove(id);
            return true;
        }
        return false;
    }

    private Long getNewID() {
        return items.lastKey() + 1;
    }
}
