package com.ramitax.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido_detalle")
public class PedidoDetalle {

    @EmbeddedId
    private PedidoDetalleKey id;

    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @MapsId("idArticulo")
    @JoinColumn(name = "id_articulo")
    private Articulo articulo;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Integer entregado;

    @Column(nullable = false)
    private Double importe;

}
