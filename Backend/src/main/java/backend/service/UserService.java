package backend.service;

import backend.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    boolean deleteUser(Long id);

    List<User> findAllUsers();

    User updateUser(Long id, User user);

    User findUserById(Long id);

    User findUserByUsernameOrEmail(String input);
}