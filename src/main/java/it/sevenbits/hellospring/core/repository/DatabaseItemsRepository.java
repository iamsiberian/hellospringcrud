package it.sevenbits.hellospring.core.repository;

import it.sevenbits.hellospring.core.model.Item;
import org.springframework.jdbc.core.JdbcOperations;
import java.util.List;

public class DatabaseItemsRepository implements ItemsRepository {

    private JdbcOperations jdbcOperations;

    public DatabaseItemsRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Item> getAllItems() {
        return jdbcOperations.query(
                "SELECT id, firstName, lastName FROM items",
                (resultSet, i) -> {
                    long rowId = resultSet.getLong(1);
                    String rowFirstName = resultSet.getString(2);
                    String rowLastName = resultSet.getString(3);
                    return new Item(rowId, rowFirstName, rowLastName);
                });

    }

    private long getNextId() {
        return jdbcOperations.queryForObject(
                "select nextval('item_id_seq')", Long.class);
    }


    @Override
    public Item create(Item newItem) {
        long rowId = getNextId();      // or generate UUID
        String rowFirstName = newItem.getLastName();
        String rowLastName = newItem.getLastName();
        int rows = jdbcOperations.update(
                "INSERT INTO items (id, firstName, lastName) VALUES (?, ?, ?)",
                rowId, rowFirstName, rowLastName
        );
        return new Item(rowId, rowFirstName, rowLastName);
    }

    @Override
    public Item getItemById(long id) {
        return jdbcOperations.queryForObject(
                "SELECT id, firstName, lastName FROM items WHERE id = ?",
                (resultSet, i) -> {
                    long rowId = resultSet.getLong(1);
                    String rowFirstName = resultSet.getString(2);
                    String rowLastName = resultSet.getString(3);
                    return new Item(rowId, rowFirstName, rowLastName);
                },
                id);
    }

    @Override
    public Item update(long id, Item newItem) {
        String firstName = newItem.getFirstName();
        String lastName = newItem.getLastName();
        int rows = jdbcOperations.update(
                "UPDATE items SET firstName = ?, lastName = ? WHERE id = ?",
                firstName, lastName, id);
        return new Item(id, firstName, lastName);
    }

    @Override
    public boolean delete(long id) {
        int rows = jdbcOperations.update(
                "DELETE FROM items WHERE id = ?",
                id
        );
        return rows > 0;
    }
}
