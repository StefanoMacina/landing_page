package com.macina.itevent.controller;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import com.macina.itevent.model.User;
import com.macina.itevent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/dashboard")
    public String viewAllUsers(
            Model model,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "page", defaultValue = "0") Integer page
    ){

        Page<User> users = userService.getAllUsers(page,size);

        System.out.println("Users List: " + (users == null ? "null" : users.getContent()));
        model.addAttribute("userslist", users);
        model.addAttribute("currentPage", page);
        return "dashboard";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){
        user.setAge();
        userService.addOneUser(user);
        System.out.println(user);
        return "redirect:/register?success";
    }




}
