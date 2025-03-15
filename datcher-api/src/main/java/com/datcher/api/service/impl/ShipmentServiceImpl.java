package com.datcher.api.service.impl;

import com.datcher.api.entities.Shipment;
import com.datcher.api.respository.IShipmentRepository;
import com.datcher.api.service.IShipmentService;
import com.datcher.api.service.mappers.IShipmentMapperDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements IShipmentService {

    @Autowired
    IShipmentRepository shipmentRepository;

    private final IShipmentMapperDomain iShipmentMapperDomain = IShipmentMapperDomain.MAPPER;

    @Override
    public Page<Shipment> findAll(Pageable pageable) {
        return shipmentRepository.findAll(pageable);
    }

    @Override
    public List<Shipment> findAll() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment findById(Long id) {
        return null;
    }

    @Override
    public Shipment save(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }


}
