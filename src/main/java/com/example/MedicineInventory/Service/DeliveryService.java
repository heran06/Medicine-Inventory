package com.example.MedicineInventory.Service;
import com.example.MedicineInventory.Entity.Delivery;
import com.example.MedicineInventory.Repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery updateStatus(Long id, String status) {
        Delivery d = deliveryRepository.findById(id).orElseThrow();
        d.setStatus(status);
        return deliveryRepository.save(d);
    }

    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id).orElseThrow();
    }

    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }
}
