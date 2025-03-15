package com.datcher.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity(name = "shipment")
@Table(name = "shipment")
@Data
public class Shipment extends Auditory implements Serializable {

    @Column(name = "income")
    private Double income;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "profit_loss")
    private Double profitLoss;
}
