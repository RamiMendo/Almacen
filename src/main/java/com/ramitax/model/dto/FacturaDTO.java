package com.ramitax.model.dto;

import com.ramitax.model.entity.Cliente;
import com.ramitax.model.entity.Pedido;
import com.ramitax.model.enumerated.MedioPago;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FacturaDTO extends ComprobanteDTO{

    private String comentarios;
    private Cliente cliente;
    private MedioPago medioPago;
    private Pedido pedido;
    private List<FacturaDetalleDTO> facturasDetalle;

}
