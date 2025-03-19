package com.datcher.api.rest.RequestDTO;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class RequestShipmentDTO implements Serializable {
    private Double income;
    private List<Double> costs;
}
