package com.ramitax.model.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MedioPago {

    VACIO(0,""),
    EFECTIVO(1,"EFECTIVO"),
    CREDITO(2,"CREDITO"),
    DEBITO(3, "DEBITO");

    @Getter
    private Integer codigo;
    @Getter
    private String nombre;

}
