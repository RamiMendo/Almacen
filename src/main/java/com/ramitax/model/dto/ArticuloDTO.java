package com.ramitax.model.dto;

import com.ramitax.enumerated.Sector;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArticuloDTO {

    private String nombre;
    private String marca;
    private Double contenido;
    private Double iva;
    private Sector sector;

}
