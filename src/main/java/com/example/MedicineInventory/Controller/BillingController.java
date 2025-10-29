package com.example.MedicineInventory.Controller;
import com.example.MedicineInventory.Entity.Billing;
import com.example.MedicineInventory.Repository.BillingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor

public class BillingController {
    private final BillingRepository billingRepo;

    @PostMapping
    public ResponseEntity<Billing>
    createBill(@RequestBody Billing billing){
        billing.setGeneratedAt(java.time.Instant.now());
        return new ResponseEntity<>(billingRepo.save(billing), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Billing> getAllBills(){
        return billingRepo.findAll();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Billing>
    updatePaymentStatus(@PathVariable Long id,@RequestParam String status){
        Billing bill = billingRepo.findById(id).orElseThrow();
        bill.setPayStatus(status);
        return ResponseEntity.ok(billingRepo.save(bill));
    }
    
}
