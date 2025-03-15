package com.datcher.api.service.mappers;

import com.datcher.api.entities.Shipment;
import com.datcher.api.rest.RequestDTO.RequestShipmentDTO;
import com.datcher.api.rest.mappers.IShipmentMapperDTO;
import com.datcher.api.service.domainModels.ShipmentDomain;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IShipmentMapperDomain {

    IShipmentMapperDomain MAPPER = Mappers.getMapper(IShipmentMapperDomain.class);

    @Mapping(source = "income", target = "income")
    public Shipment mapShipmentDomainToShipment(ShipmentDomain shipmentDomain);
}
