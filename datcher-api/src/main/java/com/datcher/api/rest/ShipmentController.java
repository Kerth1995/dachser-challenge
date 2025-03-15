package com.datcher.api.rest;

import com.datcher.api.entities.Shipment;
import com.datcher.api.rest.RequestDTO.RequestShipmentDTO;
import com.datcher.api.rest.mappers.IShipmentMapperDTO;
import com.datcher.api.service.IShipmentBusinessLogicService;
import com.datcher.api.service.IShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipment")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class ShipmentController {

    @Autowired
    IShipmentBusinessLogicService shipmentBusinessLogicService;

    @Autowired
    IShipmentService shipmentService;

    private final IShipmentMapperDTO shipmentMapperDTO = IShipmentMapperDTO.MAPPER;

    @PostMapping("/")
    ResponseEntity<?> save(@RequestBody RequestShipmentDTO data) throws Exception {
        log.info("Ingresa al metodo save del controlador");
        log.info("RequestBody {}", data.toString());
        return new ResponseEntity<>(
                shipmentMapperDTO.mapShipmentResponseDomainToShipmentResponseDTO(
                        shipmentBusinessLogicService.saveProfitOrLoss(
                                shipmentMapperDTO.mapRequestShipmentDTOToShipmentDomain(data))),
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
