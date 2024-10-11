package com.ramitax.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class FacturaDetalleKey {

    @Column(name = "id_factura")
    private Integer idFactura;

    @Column(name = "id_articulo")
    private Integer idArticulo;
}
