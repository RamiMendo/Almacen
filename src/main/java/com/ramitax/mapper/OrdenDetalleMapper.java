package com.ramitax.mapper;

import com.ramitax.model.dto.OrdenDetalleDTO;
import com.ramitax.model.entity.OrdenCompraDetalle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrdenDetalleMapper {

    OrdenCompraDetalle dtoToOrdenDetalle(OrdenDetalleDTO dto);

    List<OrdenCompraDetalle> dtoToList(List<OrdenDetalleDTO> ordenDetalleDTOS);

}
