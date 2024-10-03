package com.ramitax.model;

import com.ramitax.interfaces.Contabilizacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Entidad implements Contabilizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 25)
    private String nombre;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Column(nullable = false, length = 35)
    private String mail;

    @Column(nullable = false, length = 10)
    private String cuit;

    @Column(nullable = false)
    private Double saldo;

}
