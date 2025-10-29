package com.example.MedicineInventory.Repository;
import com.example.MedicineInventory.Entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BillingRepository extends JpaRepository<Billing,Long>{
    
}
