package com.ramitax.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Estado {

    VACIO(0,""),
    ENTREGADO(1,"Entregado"),
    CANCELADO(2,"Cancelado"),
    FINALIZADO(3,"Finalizado"),
    ANULADO(4,"Anulado"),
    PENDIENTE(5,"Pendiente"),
    ACTIVO(6,"Activo");

    @Getter
    private Integer codigo;
    @Getter
    private String nombre;
}
