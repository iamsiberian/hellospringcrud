package it.sevenbits.hellospring.core.repository;

import it.sevenbits.hellospring.core.model.Item;

import java.util.Collection;

public interface ItemsRepository {
    Collection getAllItems();

    Item create(Item newItem);

    Item getItemById(long id);

    Item update(long id, Item newItem);

    boolean delete(long id);
}
