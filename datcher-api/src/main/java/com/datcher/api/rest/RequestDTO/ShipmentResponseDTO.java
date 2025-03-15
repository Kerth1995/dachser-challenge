package com.datcher.api.rest.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentResponseDTO implements Serializable {
    private Long id;
    private Double income;
    private Double cost;
    private Double profitLoss;
}
