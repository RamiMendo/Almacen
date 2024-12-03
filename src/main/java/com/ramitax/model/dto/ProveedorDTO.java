package com.ramitax.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ProveedorDTO extends EntidadDTO{

    private DomicilioDTO domicilio;

}
