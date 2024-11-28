package com.ramitax.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class DomicilioDTO {

    private String direccion;
    private String localidad;
    private String provincia;
    private String pais;

}
