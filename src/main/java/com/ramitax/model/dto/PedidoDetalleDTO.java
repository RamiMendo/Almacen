package com.ramitax.model.dto;

import com.ramitax.model.entity.Articulo;
import com.ramitax.model.entity.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoDetalleDTO {

    private Articulo articulo;
    private Integer cantidad;
}
