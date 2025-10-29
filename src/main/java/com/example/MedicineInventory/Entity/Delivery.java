package com.example.MedicineInventory.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderId;
    private String deliveryPerson;
    private LocalDate deliveryDate;
    private String status;
}
