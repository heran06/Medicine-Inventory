package com.example.MedicineInventory.Controller;

import com.example.MedicineInventory.Entity.Order;
import com.example.MedicineInventory.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderrepo;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderrepo.save(order);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderrepo.findAll();
    }
}
