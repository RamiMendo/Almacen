package com.ramitax.mapper;

import com.ramitax.model.dto.OrdenCompraDTO;
import com.ramitax.model.entity.OrdenCompra;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrdenDetalleMapper.class})
public interface OrdenMapper {

    OrdenCompra dtoToOrden(OrdenCompraDTO dto);

}
