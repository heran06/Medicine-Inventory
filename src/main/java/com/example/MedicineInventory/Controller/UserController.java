package com.example.MedicineInventory.Controller;
import com.example.MedicineInventory.Entity.User;
import com.example.MedicineInventory.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/list";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "users/form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    
    @PostMapping("/api")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/api")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
