package com.example.MedicineInventory.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int stock;
    private String expiryDate;
    private BigDecimal price;
}
