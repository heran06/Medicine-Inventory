package com.example.MedicineInventory.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private String customerName;
    private Double totalAmount;
    private String billingDate;
    private String paymentMethod;
    private String payStatus;
    private Instant generatedAt;
}
