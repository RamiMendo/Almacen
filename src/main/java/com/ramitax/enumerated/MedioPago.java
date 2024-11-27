package com.ramitax.enumerated;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MedioPago {

    VACIO(""),
    EFECTIVO("EFECTIVO"),
    CREDITO("CREDITO"),
    DEBITO("DEBITO");

    private String nombre;

}
