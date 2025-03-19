package com.datcher.api.rest.RequestDTO;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ShipmentResponseDTO implements Serializable {
    private Long id;
    private Double income;
    private Double cost;
    private Double profitLoss;
}
