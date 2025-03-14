package com.springkt.controller;

import com.springkt.entity.User;
import com.springkt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // List all users
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/list";
    }

    // Show create form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "user/form";
    }

    // Create user
    @PostMapping
    public String createUser(@ModelAttribute("user") User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/form";
        }
        userService.createUser(user);
        return "redirect:/users";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("user", user);
        return "user/form";
    }

    // Update user
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user,
                             BindingResult result) {
        if (result.hasErrors()) {
            user.setId(id);
            return "user/form";
        }
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    // Search
    @GetMapping("/search")
    public String searchUsers(@RequestParam("name") String name, Model model) {
        model.addAttribute("users", userService.searchUsers(name));
        return "user/list";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
