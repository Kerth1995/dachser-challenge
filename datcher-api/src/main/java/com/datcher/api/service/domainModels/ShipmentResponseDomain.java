package com.datcher.api.service.domainModels;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ShipmentResponseDomain implements Serializable {
    private Long id;
    private Double income;
    private Double cost;
    private Double profitLoss;
}
