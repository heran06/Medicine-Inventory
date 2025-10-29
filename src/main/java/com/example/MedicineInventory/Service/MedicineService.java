package com.example.MedicineInventory.Service;
import com.example.MedicineInventory.Entity.Medicine;
import java.util.List;
public interface MedicineService {
    Medicine addMedicine(Medicine medicine);
    List<Medicine> getAllMedicines();
}
