package com.example.MedicineInventory.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicineId;
    private String name;
    private String supplier;
    private BigDecimal price;
    private int stock;
    private LocalDate expiryDate;
}
