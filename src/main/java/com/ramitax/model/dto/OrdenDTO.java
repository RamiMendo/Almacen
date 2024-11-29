package com.ramitax.model.dto;

import com.ramitax.model.entity.Proveedor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class OrdenDTO {

    private String comentarios;
    private LocalDate fechaEntrega;
    private Proveedor proveedor;
    private List<OrdenDetalleDTO> ordenCompraDetalle;

}
