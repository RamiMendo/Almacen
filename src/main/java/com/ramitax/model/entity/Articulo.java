package com.ramitax.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ramitax.model.enumerated.Sector;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "articulos")
@JsonIgnoreProperties({"pedidosDetalle", "ordenesCompraDetalle", "facturasDetalle"})
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idArticulo;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(nullable = false, length = 20)
    private String marca;

    @Column(nullable = false)
    private Double contenido;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Double iva;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Sector sector;

    @OneToMany(mappedBy = "articulo", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "articulo-pedido-detalle")
    private List<PedidoDetalle> pedidosDetalle;

    @OneToMany(mappedBy = "articulo", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "articulo-orden-detalle")
    private List<OrdenCompraDetalle> ordenesCompraDetalle;

    @OneToMany(mappedBy = "articulo", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "articulo-factura-detalle")
    private List<FacturaDetalle> facturasDetalle;

}
