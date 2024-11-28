package com.ramitax.mapper;

import com.ramitax.model.dto.OrdenDTO;
import com.ramitax.model.entity.OrdenCompra;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrdenDetalleMapper.class})
public interface OrdenMapper {

    OrdenCompra dtoToOrden(OrdenDTO dto);

}
