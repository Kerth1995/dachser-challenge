package com.datcher.api.service.impl;

import com.datcher.api.entities.Shipment;
import com.datcher.api.service.IShipmentBusinessLogicService;
import com.datcher.api.service.IShipmentService;
import com.datcher.api.service.domainModels.ShipmentRequestDomain;
import com.datcher.api.service.domainModels.ShipmentResponseDomain;
import com.datcher.api.service.mappers.IShipmentMapperDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentBusinessLogicServiceImpl implements IShipmentBusinessLogicService {

    @Autowired
    IShipmentService shipmentService;

    private final IShipmentMapperDomain iShipmentMapperDomain = IShipmentMapperDomain.MAPPER;

    @Override
    public Double calculateProfitOrLoss(Double income, Double totalCost) {
        return income-totalCost;
    }

    @Override
    public Double sumTotalCost(List<Double> costs){
        return costs.stream().mapToDouble(Double :: doubleValue).sum();
    }

    @Override
    public ShipmentResponseDomain saveProfitOrLoss(ShipmentRequestDomain shipmentRequestDomain) {
        Shipment shipment = iShipmentMapperDomain.mapShipmentRequestDomainToShipment(shipmentRequestDomain);
        shipment.setCost(sumTotalCost(shipmentRequestDomain.getCosts()));
        Shipment resultData = shipmentService.save(shipment);
        resultData.setProfitLoss(
                calculateProfitOrLoss(shipment.getIncome(), resultData.getCost()));
        return iShipmentMapperDomain.mapShipmentToShipmentResponseDomain(shipmentService.save(resultData));
    }
}
