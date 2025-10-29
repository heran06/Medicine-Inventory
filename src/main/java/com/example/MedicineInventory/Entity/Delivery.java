package com.example.MedicineInventory.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
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
    @OneToOne
    private Order order;

    private String deliveryPerson;
    private String status;
    private Instant dispatchAt; 
    private Instant DeliveredAt;
    
}
