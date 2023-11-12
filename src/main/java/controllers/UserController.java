package controllers;

import models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    @RequestMapping(value = "/user/getUserList", produces = "application/json")
    @ResponseBody
    public List<User> getEmployeesList() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(Long.valueOf("user_id"));
        user.setUserName("userName");
        users.add(user);
        return users;
    }
}
