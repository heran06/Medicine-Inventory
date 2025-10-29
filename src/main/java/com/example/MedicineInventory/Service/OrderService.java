package com.example.MedicineInventory.Service;

import com.example.MedicineInventory.Entity.Order;
import java.util.List;
public interface OrderService {
    Order createOrder(Order order);
    List<Order> getAllOrders();
}
