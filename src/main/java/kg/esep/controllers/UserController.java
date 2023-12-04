package kg.esep.controllers;

import kg.esep.models.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @RequestMapping(value = "/users", produces = "application/json")
    @ResponseBody
    public List<User> getEmployeesList() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(Long.valueOf("1"));
        user.setUserName("userName");
        users.add(user);
        return users;
    }
}
