package com.datcher.api.rest.mappers;

import com.datcher.api.rest.RequestDTO.RequestShipmentDTO;
import com.datcher.api.rest.RequestDTO.ShipmentResponseDTO;
import com.datcher.api.service.domainModels.ShipmentRequestDomain;
import com.datcher.api.service.domainModels.ShipmentResponseDomain;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IShipmentMapperDTO {

    IShipmentMapperDTO MAPPER = Mappers.getMapper(IShipmentMapperDTO.class);

    @Mapping(source = "income", target = "income")
    @Mapping(source = "costs", target = "costs")
    public ShipmentRequestDomain mapRequestShipmentDTOToShipmentDomain(RequestShipmentDTO requestShipmentDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "income", target = "income")
    @Mapping(source = "cost", target = "cost")
    @Mapping(source = "profitLoss", target = "profitLoss")
    public ShipmentResponseDTO mapShipmentResponseDomainToShipmentResponseDTO(ShipmentResponseDomain shipmentResponseDomain);
}
