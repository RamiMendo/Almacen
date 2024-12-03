package com.ramitax.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmpleadoDTO extends EntidadDTO{

    private String dni;
    private Double salario;
    private LocalDate fechaNacimiento;
    private DomicilioDTO domicilio;

}
