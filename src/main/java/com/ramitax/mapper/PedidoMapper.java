package com.ramitax.mapper;

import com.ramitax.model.dto.PedidoDTO;
import com.ramitax.model.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {PedidoDetalleMapper.class})
public interface PedidoMapper {

    Pedido dtoToPedido(PedidoDTO pedidoDTO);

}
