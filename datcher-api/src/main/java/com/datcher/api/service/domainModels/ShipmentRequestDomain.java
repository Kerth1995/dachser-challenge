package com.datcher.api.service.domainModels;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ShipmentRequestDomain {
    private Double income;
    private List<Double> costs;
}
