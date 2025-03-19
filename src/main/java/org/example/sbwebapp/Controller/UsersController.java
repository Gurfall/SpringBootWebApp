package org.example.sbwebapp.Controller;


import org.example.sbwebapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.example.sbwebapp.Model.User;

import java.util.List;

@Controller
public class UsersController {

@Autowired
UserService usersService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> allUsers = usersService.getAllUsers();
        System.out.println("Полученные пользователи: " + allUsers);
        model.addAttribute("allUsers", allUsers);
        return "users";
    }


    @GetMapping("/users/remove/{id}")
    public String removeUser(@PathVariable Integer id) {
        usersService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("users/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("users/add")
    public String addUser(@ModelAttribute User user) {
        usersService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("users/update/{id}")
    public String updateUserForm(@PathVariable Integer id, Model model) {
        User user = usersService.getUserById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("users/update")
    public String updateUser(@ModelAttribute User user) {
        usersService.updateUser(user);
        return "redirect:/users";
    }



}
