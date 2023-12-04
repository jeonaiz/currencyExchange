package kg.esep.services.impl;

import kg.esep.dao.UserRepository;
import io.micrometer.common.util.StringUtils;
import kg.esep.models.User;
import kg.esep.services.UserService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService
{

    public UserServiceImpl( UserRepository userRepository ) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();;
    }

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User createUser( User user ) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
            throw new IllegalArgumentException("Username and password are required");
        }

        if (userRepository.findByUserName(user.getUserName() ) != null) {
            throw new IllegalArgumentException("Username is already in use");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override

    public User updateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        if (user.getId() == null) {
            throw new IllegalArgumentException("User ID is required for update");
        }

        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser == null) {
            throw new IllegalArgumentException("User not found");
        }

        if (!StringUtils.isEmpty(user.getUserName())) {
            existingUser.setUserName(user.getUserName());
        }

        if (!StringUtils.isEmpty(user.getPassword())) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return userRepository.save(existingUser);
    }
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUserName(username );
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
