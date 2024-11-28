package com.ramitax.mapper;

import com.ramitax.model.dto.PedidoDetalleDTO;
import com.ramitax.model.entity.PedidoDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoDetalleMapper {

    PedidoDetalle dtoToPedidoDetalle(PedidoDetalleDTO dto);

    List<PedidoDetalle> dtoListToList(List<PedidoDetalleDTO> pedidoDetalleDTO);

}
