package com.datcher.api.service;

import com.datcher.api.entities.Shipment;

import java.util.List;

public interface IShipmentBusinessLogicService {

    Double calculateProfitOrLoss(Double income, Double totalCost);
    Double sumTotalCost(List<Double> costs);
}
