package com.datcher.api.service.impl;

import com.datcher.api.entities.Shipment;
import com.datcher.api.respository.IShipmentRepository;
import com.datcher.api.service.IShipmentService;
import com.datcher.api.service.mappers.IShipmentMapperDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShipmentServiceImpl implements IShipmentService {

    @Autowired
    IShipmentRepository shipmentRepository;

    private final IShipmentMapperDomain iShipmentMapperDomain = IShipmentMapperDomain.MAPPER;

    @Override
    public Page<Shipment> findAll(Pageable pageable) {
        log.info("Ingresa al metodo findAll(Pageable pageable) del servicio para persisitir en la base de datos");
        return shipmentRepository.findAll(pageable);
    }

    @Override
    public List<Shipment> findAll() {
        log.info("Ingresa al metodo findAll del servicio para persisitir en la base de datos");
        return shipmentRepository.findAll();
    }


    @Override
    public Shipment save(Shipment shipment) {
        log.info("Ingresa al metodo save del servicio para persisitir en la base de datos");
        return shipmentRepository.save(shipment);
    }


}
