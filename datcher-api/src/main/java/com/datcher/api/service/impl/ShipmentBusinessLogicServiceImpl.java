package com.datcher.api.service.impl;

import com.datcher.api.service.IShipmentBusinessLogicService;
import com.datcher.api.service.IShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentBusinessLogicServiceImpl implements IShipmentBusinessLogicService {

    @Override
    public Double calculateProfitOrLoss(Double income, Double totalCost) {
        return income-totalCost;
    }

    @Override
    public Double sumTotalCost(List<Double> costs){
        return costs.stream().mapToDouble(Double :: doubleValue).sum();
    };
}
