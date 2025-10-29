package com.example.MedicineInventory.Repository;
import com.example.MedicineInventory.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
