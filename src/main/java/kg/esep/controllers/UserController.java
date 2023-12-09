package kg.esep.controllers;

import kg.esep.models.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final List<User> users = new ArrayList<>();

    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<User> addUser(@RequestBody User newUser) {
        newUser.setAddDate(LocalDateTime.now());
        users.add(newUser);
        return users;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> getEmployeesList() {
        return users;
    }
}
