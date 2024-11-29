package com.ramitax.model.dto;

import com.ramitax.model.entity.Articulo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrdenDetalleDTO {

    private Articulo articulo;
    private Integer cantidadSolicitada;
    private Double precioCompra;

}
