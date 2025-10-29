package com.example.MedicineInventory.Service;
import com.example.MedicineInventory.Entity.Billing;
import java.util.List;
public interface BillingService {
    Billing createBill(Billing billing);
    List<Billing> getAllBills();
    Billing updatePaymentStatus(Long id,String status);
    
}
