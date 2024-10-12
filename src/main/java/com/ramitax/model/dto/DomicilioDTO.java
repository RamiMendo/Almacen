package com.ramitax.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DomicilioDTO {

    private String direccion;
    private String localidad;
    private String provincia;
    private String pais;

}
