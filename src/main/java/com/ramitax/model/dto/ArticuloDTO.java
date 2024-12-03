package com.ramitax.model.dto;

import com.ramitax.model.enumerated.Sector;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticuloDTO {

    private String nombre;
    private String marca;
    private Double contenido;
    private Double iva;
    private Sector sector;

}
