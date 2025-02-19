package com.example.myApp2.controller;
import com.example.myApp2.model.User;
import com.example.myApp2.repository.UserRepository;
import com.example.myApp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
     //step2 create instance of model
//    private final UserService userService;
//
//    public HomeController(UserService userService) {
//        this.userService = userService;
//    }
//    //step 3
//    @GetMapping ("/")//maping to home page
//   public String home(Model model) {
//        model.addAttribute("users",userService.getUsers());
//        return "home";//khong can home.html
//    }

    @Autowired
    private UserService userService;
//    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "home";


    }



    @GetMapping("/addUser")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser"; // Trả về view users/add.html
    }

    // Xử lý thêm người dùng
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/"; // Sau khi thêm, chuyển hướng về danh sách người dùng
    }

    @GetMapping("/updateUser/{id}")
    public String showUpdateUser(@ModelAttribute User user, @PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserById(id).get());
        return "updateUser";

    }

    // Xử lý sửa user
    @PostMapping("/updateUser/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute User user) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/";
    }

    // Xóa user
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
