package com.example.MedicineInventory.Repository;
import com.example.MedicineInventory.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Long>{
    
}
