package com.datcher.api.rest.mappers;

import com.datcher.api.rest.RequestDTO.RequestShipmentDTO;
import com.datcher.api.service.domainModels.ShipmentDomain;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IShipmentMapperDTO {

    IShipmentMapperDTO MAPPER = Mappers.getMapper(IShipmentMapperDTO.class);

    @Mapping(source = "income", target = "income")
    @Mapping(source = "costs", target = "costs")
    public ShipmentDomain mapRequestShipmentDTOToShipmentDomain(RequestShipmentDTO requestShipmentDTO);
}
