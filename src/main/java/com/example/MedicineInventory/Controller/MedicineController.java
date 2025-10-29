package com.example.MedicineInventory.Controller;
import com.example.MedicineInventory.Entity.Medicine;
import com.example.MedicineInventory.Repository.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medicines")
@RequiredArgsConstructor
public class MedicineController {
    private final MedicineRepository medicineRepo;

    @PostMapping
    public Medicine addMedicine(@RequestBody Medicine m){
        return medicineRepo.save(m);
    }

    @GetMapping
    public List<Medicine> getAll(){
        return medicineRepo.findAll();
    }

}
