package com.ramitax.model.dto;

import lombok.Data;

@Data
public abstract class EntidadDTO {

    private String nombre;
    private String telefono;
    private String mail;
    private String cuit;

}
