package com.ramitax.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Sector {

    VACIO( 0,""),
    LIMPIEZA(1,"Limpieza"),
    COMIDA(2,"Comida"),
    PERFUMERIA(3, "Perfumeria"),
    FARMACIA(4,"Farmacia"),
    CONGELADOS(5, "Congelados"),
    BEBIDAS(6, "Bebidas"),
    ELECTRONICA(7,"Electronica");

    @Getter
    private Integer codigo;
    @Getter
    private String nombre;

}
