package com.datcher.api.rest;

import com.datcher.api.entities.Shipment;
import com.datcher.api.rest.RequestDTO.RequestShipmentDTO;
import com.datcher.api.rest.mappers.IShipmentMapperDTO;
import com.datcher.api.service.IShipmentBusinessLogicService;
import com.datcher.api.service.IShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shipment")
public class ShipmentController {

    @Autowired
    IShipmentService shipmentService;

    private final IShipmentMapperDTO shipmentMapperDTO = IShipmentMapperDTO.MAPPER;

    @PostMapping("/")
    ResponseEntity<?> save(@RequestBody RequestShipmentDTO data){
        return new ResponseEntity<>(
                shipmentService.updateProfitOrLoss(shipmentMapperDTO.mapRequestShipmentDTOToShipmentDomain(data)),
                HttpStatus.CREATED);
    }

    @GetMapping("/")
    ResponseEntity<List<Shipment>> get(){

        /*
        Page<Shipment> data = shipmentService.findAll(PageRequest.of(0, 2));
        Map<String, Object> response = new HashMap<>();
        response.put("shipments", data.getContent());
        response.put("current-page", data.getNumber());
        response.put("total-items", data.getTotalElements());
        response.put("total-pages", data.getTotalPages());
        */
        return new ResponseEntity<List<Shipment>>(shipmentService.findAll(), HttpStatus.OK);
    }
}
