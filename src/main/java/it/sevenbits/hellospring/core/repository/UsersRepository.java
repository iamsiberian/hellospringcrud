package it.sevenbits.hellospring.core.repository;

import it.sevenbits.hellospring.core.model.User;

import java.util.List;

public interface UsersRepository {

    User findByUserName(String username);

    List<User> findAll();
}
