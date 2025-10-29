package com.example.MedicineInventory.Controller;
import com.example.MedicineInventory.Entity.Billing;
import com.example.MedicineInventory.Service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/billing")
@RequiredArgsConstructor
public class BillingController {
    private final BillingService billingService;

    
    @GetMapping
    public String listBills(Model model) {
        model.addAttribute("bills", billingService.getAllBills());
        return "billing/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("bill", new Billing());
        return "billing/form";
    }

    @PostMapping
    public String saveBill(@ModelAttribute Billing bill) {
        billingService.createBill(bill);
        return "redirect:/billing";
    }

    @GetMapping("/edit/{id}")
    public String editBill(@PathVariable Long id, Model model) {
        Billing bill = billingService.getBillById(id);
        model.addAttribute("bill", bill);
        return "billing/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteBill(@PathVariable Long id) {
        billingService.deleteBill(id);
        return "redirect:/billing";
    }

    @PostMapping("/api")
    @ResponseBody
    public ResponseEntity<Billing> createBill(@RequestBody Billing billing) {
        return new ResponseEntity<>(billingService.createBill(billing), HttpStatus.CREATED);
    }

    @GetMapping("/api")
    @ResponseBody
    public List<Billing> getAllBills() {
        return billingService.getAllBills();
    }

    @PutMapping("/api/{id}/status")
    @ResponseBody
    public ResponseEntity<Billing> updatePaymentStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(billingService.updatePaymentStatus(id, status));
    }
}
