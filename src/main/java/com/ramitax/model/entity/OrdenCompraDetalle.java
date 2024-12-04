package com.ramitax.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordenes_compras_detalle")
public class OrdenCompraDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_articulo")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonBackReference(value = "articulo-factura-detalle")
    private Articulo articulo;

    @Column(nullable = false)
    private Integer cantidadSolicitada;

    @Column(nullable = false)
    private Integer cantidadRecibidad;

    @Column(nullable = false)
    private Double precioCompra;

}