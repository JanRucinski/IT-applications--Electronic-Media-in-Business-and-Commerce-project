package backend.service;

import backend.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User deleteUser(long id);
    List<User> findAllUsers();
    User updateUser(User user);
    User findUserById(long id);
    User findUserByUsernameOrEmail(String input);
}