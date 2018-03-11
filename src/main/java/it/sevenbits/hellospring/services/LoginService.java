package it.sevenbits.hellospring.services;

import it.sevenbits.hellospring.core.model.User;
import it.sevenbits.hellospring.core.repository.UsersRepository;
import it.sevenbits.hellospring.web.models.Login;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UsersRepository users;

    public LoginService(UsersRepository users) {
        this.users = users;
    }

    public User login(Login login) {
        User user = users.findByUserName(login.getLogin());
        if (user == null) {
            throw new LoginFailedException("User not found");
        }
        if (!BCrypt.checkpw(
                login.getPassword(), user.getPassword())) {
            throw new LoginFailedException("Wrong password");
        }
        return new User(
                user.getUsername(), user.getAuthorities());

    }
}
