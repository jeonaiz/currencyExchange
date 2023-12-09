package controllers;

import dao.UserRepository;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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