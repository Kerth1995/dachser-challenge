package com.datcher.api.respository;

import com.datcher.api.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShipmentRepository extends JpaRepository<Shipment, Long> {
}
