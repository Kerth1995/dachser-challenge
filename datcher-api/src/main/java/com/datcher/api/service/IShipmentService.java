package com.datcher.api.service;

import com.datcher.api.entities.Shipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IShipmentService {

    List<Shipment> findAll();
    Page<Shipment> findAll(Pageable pageable);

    Shipment save(Shipment shipment);
}
