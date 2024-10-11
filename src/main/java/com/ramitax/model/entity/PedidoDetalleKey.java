package com.ramitax.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PedidoDetalleKey {

    @Column(name = "id_pedido")
    private Integer idPedido;

    @Column(name = "id_articulo")
    private Integer idArticulo;

}
