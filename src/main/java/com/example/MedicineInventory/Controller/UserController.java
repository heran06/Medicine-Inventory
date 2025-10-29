package com.example.MedicineInventory.Controller;
import com.example.MedicineInventory.Entity.User;
import com.example.MedicineInventory.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class UserController {
    private final UserRepository userrepo;

    @PostMapping
    public User addUser(@RequestBody User user){
        return userrepo.save(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userrepo.findAll();

    }
}
