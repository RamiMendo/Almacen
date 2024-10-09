package com.ramitax.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EmpleadoDTO extends EntidadDTO{

    private String dni;
    private Double salario;
    private LocalDate fechaNacimiento;

}
