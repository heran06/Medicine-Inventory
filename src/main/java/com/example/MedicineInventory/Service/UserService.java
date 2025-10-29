package com.example.MedicineInventory.Service;
import com.example.MedicineInventory.Entity.User;
import java.util.List;
public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
}
