package com.ramitax.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado extends Entidad{

    @Column(nullable = false, length = 8)
    private String dni;

    @Column(nullable = false)
    private Double salario;

    @Column(nullable = false)
    private LocalDate fechaAlta;

    @Column(nullable = false)
    private LocalDate fechaBaja;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Domicilio domicilio;

}
