package com.example.MedicineInventory.Controller;

import com.example.MedicineInventory.Entity.Order;
import com.example.MedicineInventory.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders/list";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("order", new Order());
        return "orders/form";
    }

    @PostMapping
    public String saveOrder(@ModelAttribute Order order) {
        orderService.createOrder(order);
        return "redirect:/orders";
    }

   
    @PostMapping("/api")
    @ResponseBody
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/api")
    @ResponseBody
    public List<Order> getAll() {
        return orderService.getAllOrders();
    }
}
