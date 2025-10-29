package com.example.MedicineInventory.Controller;
import com.example.MedicineInventory.Entity.Medicine;
import com.example.MedicineInventory.Service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/medicines")
@RequiredArgsConstructor
public class MedicineController {
    private final MedicineService medicineService;

    
    @GetMapping
    public String listMedicines(Model model) {
        model.addAttribute("medicines", medicineService.getAllMedicines());
        return "medicines/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("medicine", new Medicine());
        return "medicines/form";
    }

    @PostMapping
    public String saveMedicine(@ModelAttribute Medicine medicine) {
        medicineService.addMedicine(medicine);
        return "redirect:/medicines";
    }

    
    @PostMapping("/api")
    @ResponseBody
    public Medicine addMedicine(@RequestBody Medicine m) {
        return medicineService.addMedicine(m);
    }

    @GetMapping("/api")
    @ResponseBody
    public List<Medicine> getAll() {
        return medicineService.getAllMedicines();
    }

}
