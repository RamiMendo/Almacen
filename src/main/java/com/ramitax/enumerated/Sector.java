package com.ramitax.enumerated;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Sector {

    VACIO( ""),
    LIMPIEZA("Limpieza"),
    COMIDA("Comida"),
    PERFUMERIA( "Perfumeria"),
    FARMACIA("Farmacia"),
    CONGELADOS( "Congelados"),
    BEBIDAS( "Bebidas"),
    ELECTRONICA("Electronica");

    private String nombre;

}
