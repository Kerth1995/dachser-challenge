package com.datcher.api.service.impl;

import com.datcher.api.entities.Shipment;
import com.datcher.api.service.IShipmentBusinessLogicService;
import com.datcher.api.service.IShipmentService;
import com.datcher.api.service.domainModels.ShipmentRequestDomain;
import com.datcher.api.service.domainModels.ShipmentResponseDomain;
import com.datcher.api.service.mappers.IShipmentMapperDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShipmentBusinessLogicServiceImpl implements IShipmentBusinessLogicService {

    @Autowired
    IShipmentService shipmentService;

    private final IShipmentMapperDomain iShipmentMapperDomain = IShipmentMapperDomain.MAPPER;

    @Override
    public Double calculateProfitOrLoss(Double income, Double totalCost) {
        log.info("Ingresa al metodo calculateProfitOrLoss del servicio para calcular el profit y loss");
        return income-totalCost;
    }

    @Override
    public Double sumTotalCost(List<Double> costs){
        log.info("Ingresa al metodo sumTotalCost del servicio para sumar el total de los costos");
        return costs.stream().mapToDouble(Double :: doubleValue).sum();
    }

    @Override
    public ShipmentResponseDomain saveProfitOrLoss(ShipmentRequestDomain shipmentRequestDomain) throws Exception {
        log.info("Ingresa al metodo saveProfitOrLoss del servicio para guardar el pofit y loss");
        try {
            Shipment shipment = iShipmentMapperDomain.mapShipmentRequestDomainToShipment(shipmentRequestDomain);
            shipment.setCost(sumTotalCost(shipmentRequestDomain.getCosts()));
            Shipment resultData = shipmentService.save(shipment);
            resultData.setProfitLoss(
                    calculateProfitOrLoss(shipment.getIncome(), resultData.getCost()));
            return iShipmentMapperDomain.mapShipmentToShipmentResponseDomain(shipmentService.save(resultData));
        }catch (Exception ex){
            log.error("Error {}", ex.getStackTrace());
            throw new Exception("Error calculating the profit and loss of the shipment", ex.getCause());
        }
    }
}
