package com.example.MedicineInventory.Controller;
import com.example.MedicineInventory.Entity.Delivery;
import com.example.MedicineInventory.Service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/deliveries")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    
    @GetMapping
    public String listDeliveries(Model model) {
        model.addAttribute("deliveries", deliveryService.getAllDeliveries());
        return "delivery/list";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("delivery", new Delivery());
        return "delivery/form";
    }

    @PostMapping
    public String saveDelivery(@ModelAttribute Delivery delivery) {
        deliveryService.createDelivery(delivery);
        return "redirect:/deliveries";
    }

    @GetMapping("/edit/{id}")
    public String editDelivery(@PathVariable Long id, Model model) {
        Delivery delivery = deliveryService.getDeliveryById(id);
        model.addAttribute("delivery", delivery);
        return "delivery/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
        return "redirect:/deliveries";
    }

    
    @PostMapping("/api")
    @ResponseBody
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
        return new ResponseEntity<>(deliveryService.createDelivery(delivery), HttpStatus.CREATED);
    }

    @GetMapping("/api")
    @ResponseBody
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @PutMapping("/api/{id}/status")
    @ResponseBody
    public ResponseEntity<Delivery> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(deliveryService.updateStatus(id, status));
    }
}
