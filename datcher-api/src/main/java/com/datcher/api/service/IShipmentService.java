package com.datcher.api.service;

import com.datcher.api.entities.Shipment;
import com.datcher.api.service.domainModels.ShipmentDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IShipmentService {

    List<Shipment> findAll();
    Page<Shipment> findAll(Pageable pageable);
    Shipment findById(Long id);

    Shipment save(Shipment shipment);
    Shipment updateProfitOrLoss(ShipmentDomain shipment);
}
