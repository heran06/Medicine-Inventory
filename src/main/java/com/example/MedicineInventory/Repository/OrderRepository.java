package com.example.MedicineInventory.Repository;

import com.example.MedicineInventory.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long>{
    
}
