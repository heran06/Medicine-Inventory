package com.example.MedicineInventory.Controller;
import com.example.MedicineInventory.Entity.Delivery;
import com.example.MedicineInventory.Repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
@RequiredArgsConstructor


public class DeliveryController {
    private final DeliveryRepository deliveryRepo;

    @PostMapping
    public ResponseEntity<Delivery> 
    createDelivery(@RequestBody Delivery delivery){
        return new ResponseEntity<>(deliveryRepo.save(delivery), HttpStatus.CREATED);

    }

    @GetMapping
    public List<Delivery> getAllDeliveries(){
        return deliveryRepo.findAll();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Delivery>
    updateStatus(@PathVariable Long id,@RequestParam String status){
        Delivery d = deliveryRepo.findById(id).orElseThrow();
        d.setStatus(status);
        return ResponseEntity.ok(deliveryRepo.save(d));
    }


}
