package kg.esep.controllers;

import kg.esep.dao.UserRepository;
import kg.esep.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;


    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();;

    @GetMapping("/registration")
    public String registrationForm() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEnabled(true);
        userRepository.save(user);
        return "redirect:/login";
    }
}