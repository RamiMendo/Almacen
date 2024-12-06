package com.ramitax.model.entity;

import com.ramitax.model.enumerated.Estado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Estado estado;

    @Column(length = 50)
    private String comentarios;

}
