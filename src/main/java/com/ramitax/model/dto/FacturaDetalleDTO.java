package com.ramitax.model.dto;

import com.ramitax.model.entity.Articulo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FacturaDetalleDTO {

    private Articulo articulo;
    private Integer cantidad;
    private Double precio;
    private Double descuento;

}
