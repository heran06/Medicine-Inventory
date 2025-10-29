package com.example.MedicineInventory.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private String customerName;

    private Double totalAmount;

    private LocalDate billingDate; 

    private String paymentMethod;

    private String payStatus;

    @Builder.Default
    private Instant generatedAt = Instant.now(); 
}
