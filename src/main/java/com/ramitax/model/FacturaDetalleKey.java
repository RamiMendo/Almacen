package com.ramitax.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FacturaDetalleKey {

    @Column(name = "id_factura")
    private Integer idFactura;

    @Column(name = "id_articulo")
    private Integer idArticulo;
}
