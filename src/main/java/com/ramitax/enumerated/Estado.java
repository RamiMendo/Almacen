package com.ramitax.enumerated;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Estado {

    VACIO(""),
    ENTREGADO("Entregado"),
    CANCELADO("Cancelado"),
    FINALIZADO("Finalizado"),
    ANULADO("Anulado"),
    PENDIENTE("Pendiente"),
    ACTIVO("Activo");

    private String nombre;
}
