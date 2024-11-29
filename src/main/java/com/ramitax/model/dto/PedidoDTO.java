package com.ramitax.model.dto;

import com.ramitax.model.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class PedidoDTO {

    private String comentarios;
    private LocalDate fechaEntrega;
    private Cliente cliente;
    private List<PedidoDetalleDTO> pedidoDetalles;
}
