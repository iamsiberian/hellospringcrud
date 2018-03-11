package it.sevenbits.hellospring.core.repository;

import it.sevenbits.hellospring.core.model.User;

import java.util.*;

public class SampleUsersRepository implements UsersRepository {

    private final Map<String, User> users = new HashMap<>();

    public SampleUsersRepository() {
        users.put("admin",
                new User("admin", "$2a$10$UeMJWRNWF.lRU/MN6xCYMeAMl5L3L0t4Nm.MXUeltdNfV/fz3B83u",
                        Arrays.asList("ADMIN", "USER")));
        users.put("guest",
                new User("guest", "$2a$10$rZ14r48ay82okhyZKZNKpeKmXv2OSqyV4LIN5U/G2G7PrMLCFfSDW",
                        Collections.singletonList("GUEST")));
    }

    @Override
    public User findByUserName(String username) {
        return users.get(username);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
}
