package kg.esep.services;

import kg.esep.models.User;

import java.util.List;


public interface UserService {
    User createUser( User user );
    User updateUser(User user);
    void deleteUser(Long userId);
    User getUserById(Long userId);
    User getUserByUsername(String username);
    List<User> getAllUsers();
}
