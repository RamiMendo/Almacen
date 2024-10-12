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
    private Long idPedido;

    @Column(name = "id_articulo")
    private Long idArticulo;

}
