package com.example.MedicineInventory.Service;
import com.example.MedicineInventory.Entity.Billing;
import com.example.MedicineInventory.Repository.BillingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillingService {
    private final BillingRepository billingRepository;

    public Billing createBill(Billing billing) {
        billing.setGeneratedAt(java.time.Instant.now());
        return billingRepository.save(billing);
    }

    public List<Billing> getAllBills() {
        return billingRepository.findAll();
    }

    public Billing updatePaymentStatus(Long id, String status) {
        Billing bill = billingRepository.findById(id).orElseThrow();
        bill.setPayStatus(status);
        return billingRepository.save(bill);
    }

    public Billing getBillById(Long id) {
        return billingRepository.findById(id).orElseThrow();
    }

    public void deleteBill(Long id) {
        billingRepository.deleteById(id);
    }
}
