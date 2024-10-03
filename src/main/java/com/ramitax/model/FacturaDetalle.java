package com.ramitax.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturas_detalle")
public class FacturaDetalle {

    @EmbeddedId
    private FacturaDetalleKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Factura factura;

    @ManyToOne(fetch = FetchType.LAZY)
    private Articulo articulo;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Double descuento;

    @Column(nullable = false)
    private Double totalArticulo;

}
