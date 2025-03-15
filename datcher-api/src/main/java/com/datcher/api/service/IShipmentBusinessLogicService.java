package com.datcher.api.service;

import com.datcher.api.entities.Shipment;
import com.datcher.api.service.domainModels.ShipmentRequestDomain;
import com.datcher.api.service.domainModels.ShipmentResponseDomain;

import java.util.List;

public interface IShipmentBusinessLogicService {

    Double calculateProfitOrLoss(Double income, Double totalCost);
    Double sumTotalCost(List<Double> costs);

    ShipmentResponseDomain saveProfitOrLoss(ShipmentRequestDomain shipmentRequestDomain);
}
