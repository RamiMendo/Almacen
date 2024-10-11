package com.ramitax.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordenes_compras_detalle")
public class OrdenCompraDetalle extends OrdenCompra{

    @ManyToOne(fetch = FetchType.LAZY)
    private Articulo articulo;

    @Column(nullable = false)
    private Integer cantidadSolicitada;

    @Column(nullable = false)
    private Integer cantidadRecibidad;

    @Column(nullable = false)
    private Double precioCompra;

    @Column(nullable = false)
    private Double totalArticulo;

}