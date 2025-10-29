package com.example.MedicineInventory.Service;
import com.example.MedicineInventory.Entity.Delivery;
import java.util.List;
public interface DeliveryService {
    Delivery createDelivery(Delivery delivery);
    List<Delivery> getAllDeliveries();
    Delivery updateStatus(Long id,String status);
    
}
