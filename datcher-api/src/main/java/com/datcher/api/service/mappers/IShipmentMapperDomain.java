package com.datcher.api.service.mappers;

import com.datcher.api.entities.Shipment;
import com.datcher.api.service.domainModels.ShipmentRequestDomain;
import com.datcher.api.service.domainModels.ShipmentResponseDomain;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IShipmentMapperDomain {

    IShipmentMapperDomain MAPPER = Mappers.getMapper(IShipmentMapperDomain.class);

    @Mapping(source = "income", target = "income")
    public Shipment mapShipmentRequestDomainToShipment(ShipmentRequestDomain shipmentRequestDomain);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "income", target = "income")
    @Mapping(source = "cost", target = "cost")
    @Mapping(source = "profitLoss", target = "profitLoss")
    public ShipmentResponseDomain mapShipmentToShipmentResponseDomain(Shipment shipment);
}
